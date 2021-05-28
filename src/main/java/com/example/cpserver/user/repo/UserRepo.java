package com.example.cpserver.user.repo;

import com.example.cpserver.user.model.User;
import com.example.cpserver.user.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findUserByLoginEquals(String login);
    Optional<User> findByIdEquals(Integer id);
    List<User> findAllByRole(UserRole userRole);
    boolean existsByLogin(String login);
    User getUserByLogin(String login);


}
