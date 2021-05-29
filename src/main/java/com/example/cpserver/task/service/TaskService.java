package com.example.cpserver.task.service;

import com.example.cpserver.general.dto.Message;
import com.example.cpserver.task.controller.dto.CreateTaskDto;
import com.example.cpserver.task.model.Task;
import com.example.cpserver.task.repo.TaskRepo;
import com.example.cpserver.theme.model.Theme;
import com.example.cpserver.theme.repo.ThemeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepo taskRepo;
    private final ThemeRepo themeRepo;

    @Autowired
    public TaskService(TaskRepo taskRepo, ThemeRepo themeRepo) {
        this.taskRepo = taskRepo;
        this.themeRepo = themeRepo;
    }

    public Message createTask(CreateTaskDto createTaskDto){
        Optional<Theme> theme = themeRepo.findById(createTaskDto.getIdTheme());
        if(!theme.isPresent()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Такой темы нет");
        }
        if(taskRepo.existsByName(createTaskDto.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Задача с таким названием уже существует");
        }
        ArrayList<String> res = new ArrayList<>();
        String  link;
        link = createTaskDto.getLink();
        String error = "problem";
        String token = "";
        int cout = 0;
        boolean fl = false;
        for (int i = link.length()-1; i >=0; i--) {
            if(fl){
                break;
            }
            if(link.charAt(i) != '/'){
                token+=link.charAt(i);
            }else {
               if(cout < 3){
                   if(!token.equals(error)){
                       res.add(token);
                   }
                   token="";
                   cout++;
               }else {
                   fl = true;
               }
            }
        }
        Task task = new Task();
        task.setName(createTaskDto.getName());
        task.setLink(link);
        task.setSecond_key(new StringBuilder(res.get(0)).reverse().toString());
        task.setFirst_key(Long.parseLong(new StringBuilder(res.get(1)).reverse().toString()));
        task.setTheme(theme.get());
        task.setNumber(theme.get().getCount());
        try {
            theme.get().getTasks().add(task);
            theme.get().setCount(theme.get().getCount()+1);
            taskRepo.save(task);
            themeRepo.save(theme.get());
            return new Message("task created");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ошибка сервера");
        }

    }
}
