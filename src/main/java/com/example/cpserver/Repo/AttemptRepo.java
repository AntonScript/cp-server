package com.example.cpserver.Repo;

import com.example.cpserver.model.Attempt;
import com.example.cpserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttemptRepo extends JpaRepository<Attempt, Long> {
    boolean existsByUserAndContestIdAndIndex(User user, Long contestId, String index);
    Attempt findByUserAndContestIdAndIndex(User user, Long contestId, String index);
}
