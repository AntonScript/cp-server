package com.example.cpserver.task.repo;

import com.example.cpserver.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
    boolean existsByName(String name);
}
