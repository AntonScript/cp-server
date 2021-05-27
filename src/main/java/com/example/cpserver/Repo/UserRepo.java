package com.example.cpserver.Repo;

import com.example.cpserver.model.User;
import com.example.cpserver.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findUserByLoginEquals(String login);
    Optional<User> findByIdEquals(Integer id);
    List<User> findAllByRole(UserRole userRole);
    boolean existsByLogin(String login);
    User getUserByLogin(String login);


}
