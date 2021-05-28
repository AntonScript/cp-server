package com.example.cpserver.theme.service;

import com.example.cpserver.general.dto.Message;
import com.example.cpserver.theme.controller.dto.CreateThemeDto;
import com.example.cpserver.theme.model.Theme;
import com.example.cpserver.theme.repo.ThemeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ThemeService {

    private final ThemeRepo themeRepo;

    @Autowired
    public ThemeService(ThemeRepo themeRepo) {
        this.themeRepo = themeRepo;
    }

    public Message createTheme(CreateThemeDto createThemeDto){
        Theme theme = new Theme();
        theme.setName(createThemeDto.getName());
        if(themeRepo.existsByName(createThemeDto.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Такая тема уже есть");
        }

        try {
            themeRepo.save(theme);
            return new Message("тема создана");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ошибка сервера");
        }

    }

    public List<Theme> getThemeAll(){
        return themeRepo.findAll();
    }
}
