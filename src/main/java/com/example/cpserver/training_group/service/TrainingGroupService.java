package com.example.cpserver.training_group.service;

import com.example.cpserver.task.model.Task;
import com.example.cpserver.theme.model.Theme;
import com.example.cpserver.theme.repo.ThemeRepo;
import com.example.cpserver.training_group.controller.dto.*;
import com.example.cpserver.training_group.repo.TrainingGroupRepo;
import com.example.cpserver.general.dto.Message;
import com.example.cpserver.training_group.model.TrainingGroup;
import com.example.cpserver.user.model.Attempt;
import com.example.cpserver.user.model.User;
import com.example.cpserver.user.repo.AttemptRepo;
import com.example.cpserver.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class TrainingGroupService {
    private final TrainingGroupRepo trainingGroupRepo;
    private final ThemeRepo themeRepo;
    private final UserRepo userRepo;
    private final AttemptRepo attemptRepo;

    @Autowired
    public TrainingGroupService(TrainingGroupRepo trainingGroupRepo, ThemeRepo themeRepo, UserRepo userRepo, AttemptRepo attemptRepo) {
        this.trainingGroupRepo = trainingGroupRepo;
        this.themeRepo = themeRepo;
        this.userRepo = userRepo;
        this.attemptRepo = attemptRepo;
    }

    @Transactional
    public Message createGroup(CreateGroupDto createGroupDto){
        TrainingGroup trainingGroup = new TrainingGroup();
        trainingGroup.setName(createGroupDto.getName());

        if(trainingGroupRepo.existsByName(createGroupDto.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Такая группа уже есть");
        }

        try {
            trainingGroupRepo.save(trainingGroup);
            return new Message("Группа создана");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ошибка сервера");
        }
    }

    public TableGroupDto getGroup(Long id){
        Optional<TrainingGroup> trainingGroup = trainingGroupRepo.findById(id);
        if(!trainingGroup.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ошибка такой группы нет");
        }
        TrainingGroup resGroup = trainingGroup.get();
        List<User> users = new ArrayList<>(resGroup.getUsers());
        List<Theme> themes = new ArrayList<>(resGroup.getThemes());
        TableGroupDto tableGroupDto = new TableGroupDto();
        tableGroupDto.setName(resGroup.getName());
        tableGroupDto.setId(resGroup.getId());
        List<TableThemeDto> list = new ArrayList<>();
        for(Theme theme : themes){
            list.add(tableThemeDto(theme, users));
        }
        tableGroupDto.setListTheme(list);




        return  tableGroupDto;
    }

    public TableThemeDto tableThemeDto(Theme theme, List<User> users){
        String name = theme.getName();
        List<TableTaskDto> tableTaskDtos = tableTaskDto((new ArrayList<>(theme.getTasks())));
        TableThemeDto tableThemeDto = new TableThemeDto(name, tableTaskDtos);
        tableThemeDto.setListUser(tableUserDto(users,new ArrayList<>(theme.getTasks())));

        return tableThemeDto;
    }


    public List<TableTaskDto> tableTaskDto(List<Task> tasks){
        List<TableTaskDto> tableTaskDtos = new ArrayList<>();
        for (Task task : tasks){
            tableTaskDtos.add(new TableTaskDto(task));
        }

        return tableTaskDtos;

    }

    public List<TableUserDto> tableUserDto(List<User> users, List<Task> tasks){
        List<TableUserDto> list = new ArrayList<>();
        for(User user : users){
            List<TableAttemptDto> listAttempt = tableAttemptDto(user, new ArrayList<>(user.getAttempts()), tasks);
            List<TableAttemptDto> res = new ArrayList<>();



            list.add(new TableUserDto(
                    user.getId(),
                    user.getLogin(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getPatronymic(),
                    listAttempt
            ));
        }

        return list;
    }


    public List<TableAttemptDto> tableAttemptDto (User user, List<Attempt> list, List<Task> tasks){
        List<TableAttemptDto> res = new ArrayList<>();
        for(Task task : tasks){
            if(attemptRepo.existsByUserAndContestIdAndIndex(user, task.getFirst_key(),task.getSecond_key())){
                Attempt  attempt = attemptRepo.findByUserAndContestIdAndIndex(user, task.getFirst_key(),task.getSecond_key());
                res.add(new TableAttemptDto(attempt));
            }else {
                res.add(null);
            }

        }
        return res;
    }



    public List<TrainingGroup> getAll(){
        return trainingGroupRepo.findAll();
    }

    @Transactional
    public Message updateGroup(UpdateGroupDto updateGroupDto){
        Optional<TrainingGroup> trainingGroup = trainingGroupRepo.findById(updateGroupDto.getId());
        if(!trainingGroup.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ошибка такой группы нет");
        }
        try {
            List<Theme> addTheme = themeRepo.findAllById(updateGroupDto.getAddTheme());
            trainingGroup.get().getThemes().addAll(addTheme);
            List<Theme> delTheme = themeRepo.findAllById(updateGroupDto.getDeleteTheme());
            delTheme.forEach(trainingGroup.get().getThemes()::remove);

            List<User> addUsers = userRepo.findAllById(updateGroupDto.getAddUsers());
            trainingGroup.get().getUsers().addAll(addUsers);
            addUsers.forEach(user -> user.getTrainingGroups().add(trainingGroup.get()));
            List<User> delUsers = userRepo.findAllById(updateGroupDto.getDeleteUsers());
            delUsers.forEach(trainingGroup.get().getUsers()::remove);
            delUsers.forEach(user -> user.getTrainingGroups().remove(trainingGroup.get()));
            trainingGroupRepo.save(trainingGroup.get());
            return new Message("ok");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ошибка сервера");

        }
    }
}
