package com.example.cpserver.service.cf;

import com.example.cpserver.Repo.AttemptRepo;
import com.example.cpserver.Repo.UserRepo;
import com.example.cpserver.controller.dto.Message;
import com.example.cpserver.controller.user.dto.CfProblem;
import com.example.cpserver.controller.user.dto.CfResultPackage;
import com.example.cpserver.controller.user.dto.CfUserStatus;
import com.example.cpserver.model.Attempt;
import com.example.cpserver.model.User;
import com.example.cpserver.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CfService {

    private final UserRepo userRepo;
    private final AttemptRepo attemptRepo;

    @Autowired
    public CfService(UserRepo userRepo, AttemptRepo attemptRepo) {
        this.userRepo = userRepo;
        this.attemptRepo = attemptRepo;
    }

    @Async("processExecutor")
    public void parseUser(){
        List<User> list = userRepo.findAllByRole(UserRole.USER);
        for (User user : list){
            updateInfoUser(user);
        }

    }

    public void updateInfoUser(User user){
        RestTemplate restTemplate = new RestTemplate();
        CfUserStatus cfUserStatus = restTemplate.getForObject(
                "https://codeforces.com/api/user.status?handle=" + user.getHandle() + "&from=1",
                CfUserStatus.class,
                CfResultPackage.class,
                CfProblem.class
        );

        List<CfResultPackage> cfResultPackages = cfUserStatus.getResult().
                stream().
                filter(cfResultPackage -> cfResultPackage.getId() > user.getLastIdAttempt()).
                collect(Collectors.toList());


        for(CfResultPackage res : cfResultPackages){
            if(attemptRepo.existsByUserAndContestIdAndIndex(user,res.getProblem().getContestId(),res.getProblem().getIndex())){
                Attempt attempt = attemptRepo.findByUserAndContestIdAndIndex(user,res.getProblem().getContestId(),res.getProblem().getIndex());
                if(!attempt.getResult()){
                    attempt.setNumberOfAttempts(attempt.getNumberOfAttempts() + 1);
                    attempt.setLanguage(res.getProgrammingLanguage());
                    if(res.getVerdict().equals("")){
                        attempt.setResult(true);
                    }
                    attemptRepo.save(attempt);
                }

            }else {
                Attempt attempt = new Attempt();
                attempt.setResult(false);
                if(res.getVerdict().equals("")){
                    attempt.setResult(true);
                }
                attempt.setUser(user);
                attempt.setNumberOfAttempts(1);
                attempt.setLanguage(res.getProgrammingLanguage());
                attempt.setContestId(res.getProblem().getContestId());
                attempt.setIndex(res.getProblem().getIndex());
                attemptRepo.save(attempt);
            }
            user.setLastIdAttempt(res.getId());

        }
        userRepo.save(user);

    }
}
