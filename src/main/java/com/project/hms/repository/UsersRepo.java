package com.project.hms.repository;

import com.project.hms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<User,Integer> {

    User findByUsername(String username);

}
