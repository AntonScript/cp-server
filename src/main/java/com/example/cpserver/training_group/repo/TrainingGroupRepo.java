package com.example.cpserver.training_group.repo;

import com.example.cpserver.training_group.model.TrainingGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingGroupRepo extends JpaRepository<TrainingGroup, Long> {
    boolean existsByName(String name);
}
