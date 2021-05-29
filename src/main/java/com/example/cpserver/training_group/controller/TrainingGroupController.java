package com.example.cpserver.training_group.controller;

import com.example.cpserver.general.dto.Message;
import com.example.cpserver.training_group.controller.dto.CreateGroupDto;
import com.example.cpserver.training_group.controller.dto.TableGroupDto;
import com.example.cpserver.training_group.controller.dto.UpdateGroupDto;
import com.example.cpserver.training_group.model.TrainingGroup;
import com.example.cpserver.training_group.service.TrainingGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public TableGroupDto getGroup(@RequestParam("id") Long id){
        return trainingGroupService.getGroup(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Message createGroup(@RequestBody  CreateGroupDto createGroupDto){
        return trainingGroupService.createGroup(createGroupDto);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<TrainingGroup> getALl(){
        return trainingGroupService.getAll();
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public Message updateGroup(@RequestBody UpdateGroupDto updateGroupDto){
        return trainingGroupService.updateGroup(updateGroupDto);
    }
}
