package com.example.cpserver.training_group.controller;

import com.example.cpserver.general.dto.Message;
import com.example.cpserver.training_group.controller.dto.CreateGroupDto;
import com.example.cpserver.training_group.model.TrainingGroup;
import com.example.cpserver.training_group.service.TrainingGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training-group")
public class TrainingGroupController {
    private final TrainingGroupService trainingGroupService;

    @Autowired
    public TrainingGroupController(TrainingGroupService trainingGroupService) {
        this.trainingGroupService = trainingGroupService;
    }

   /* @GetMapping
    public TrainingGroup getGroup(RequestParam Long ("id") id){

    }*/

    @PostMapping
    public Message createGroup(@RequestBody  CreateGroupDto createGroupDto){
        return trainingGroupService.createGroup(createGroupDto);
    }

    @GetMapping("/all")
    public List<TrainingGroup> getALl(){
        return trainingGroupService.getAll();
    }
}
