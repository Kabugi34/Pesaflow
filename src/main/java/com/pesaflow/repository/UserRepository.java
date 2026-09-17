package com.pesaflow.repository;

import com.pesaflow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long>{
    

}
