package com.sudip.taskapp.repository;

import com.sudip.taskapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u from User u WHERE u.userName= :uname" )
    public  User login(@Param("uname") String uname);
}
