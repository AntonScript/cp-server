package com.example.cpserver.service.user;

import com.example.cpserver.Repo.UserRepo;
import com.example.cpserver.congif.JwtUtil;
import com.example.cpserver.controller.dto.Message;
import com.example.cpserver.controller.dto.Token;
import com.example.cpserver.controller.user.dto.AuthUserDto;
import com.example.cpserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserService(UserRepo userRepo, JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.jwtUtil = jwtUtil;
    }


    public Message regUser(User user){
        if(userRepo.existsByLogin(user.getLogin())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Пользователь с таким логином уже существует");
        }

        try {
            userRepo.save(user);
            return new Message("Пользователь зарегистрирован");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ошибка сервера");
        }
    }


    public User getUser(Integer id){
        if(!userRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Пользователь с таким id уже существует");
        }
        Optional<User> user = userRepo.findByIdEquals(id);
        return user.get();
    }

    @Transactional
    public Token logUser(AuthUserDto user){
        if(user.login == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Введите логин");
        }
        if(user.password == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Введите пароль");
        }
        if(!userRepo.existsByLogin(user.login)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Пользователя с таким логином не существует");
        }
        User authUser = userRepo.getUserByLogin(user.login);
        if(authUser.getPassword().equals(user.password )){
            String token = jwtUtil.generateToken(authUser);
            return new Token(token);
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Неверный пароль");
        }
    }
}
