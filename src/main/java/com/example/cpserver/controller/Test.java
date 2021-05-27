package com.example.cpserver.controller;

import com.example.cpserver.controller.user.dto.CfProblem;
import com.example.cpserver.controller.user.dto.CfResultPackage;
import com.example.cpserver.controller.user.dto.CfUserStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class Test {

    @GetMapping("/test")
    public ResponseEntity<?> t(){
        RestTemplate restTemplate = new RestTemplate();
        CfUserStatus page = restTemplate.getForObject(
                "https://codeforces.com/api/user.status?handle=prideblack&from=1",
                CfUserStatus.class,
                CfResultPackage.class,
                CfProblem.class
        );
        System.out.println(page);
        return  new ResponseEntity<>(page, HttpStatus.OK);

    }

    @PostMapping("/test")
    public ResponseEntity<?> t1(
            @RequestBody CfUserStatus cfUserStatus
    ){
        System.out.println(cfUserStatus);
        RestTemplate restTemplate = new RestTemplate();
        CfUserStatus page = restTemplate.getForObject("https://codeforces.com/api/user.rating?handle=prideblack", CfUserStatus.class);
        System.out.println(page);
        return  new ResponseEntity<>(page, HttpStatus.OK);

    }


}
