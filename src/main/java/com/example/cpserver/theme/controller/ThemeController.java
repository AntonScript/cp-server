package com.example.cpserver.theme.controller;

import com.example.cpserver.general.dto.Message;
import com.example.cpserver.theme.controller.dto.CreateThemeDto;
import com.example.cpserver.theme.model.Theme;
import com.example.cpserver.theme.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theme")
public class ThemeController {

    private final ThemeService themeService;

    @Autowired
    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }


    @PostMapping
    public Message createTheme(@RequestBody CreateThemeDto createThemeDto){
        return themeService.createTheme(createThemeDto);
    }

    @GetMapping("/all")
    public List<Theme> getAllTheme(){
        return themeService.getThemeAll();
    }



}
