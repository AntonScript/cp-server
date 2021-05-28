package com.example.cpserver.training_group.service;

import com.example.cpserver.training_group.repo.TrainingGroupRepo;
import com.example.cpserver.general.dto.Message;
import com.example.cpserver.training_group.controller.dto.CreateGroupDto;
import com.example.cpserver.training_group.model.TrainingGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TrainingGroupService {
    private final TrainingGroupRepo trainingGroupRepo;

    @Autowired
    public TrainingGroupService(TrainingGroupRepo trainingGroupRepo) {
        this.trainingGroupRepo = trainingGroupRepo;
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

    public List<TrainingGroup> getAll(){
        return trainingGroupRepo.findAll();
    }
}
