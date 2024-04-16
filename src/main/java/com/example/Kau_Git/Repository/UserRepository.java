package com.example.Kau_Git.Repository;

import com.example.Kau_Git.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserId(long userId);

    Optional<User> findByEmail(String email);

}
