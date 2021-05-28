package com.example.cpserver.theme.repo;

import com.example.cpserver.theme.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepo extends JpaRepository<Theme, Long> {
    boolean existsByName(String name);
}
