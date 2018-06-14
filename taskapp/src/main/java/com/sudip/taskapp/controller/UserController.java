package com.sudip.taskapp.controller;

import com.sudip.taskapp.model.User;
import com.sudip.taskapp.repository.UserRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * UserController class is a controller class that performs all the user context functionality.The user functionaliy are based on the API Url.
 * User object encapsulates all the  informations  for various user operation in the application. The information
 * contains in the user object are:
 * <ul>
 *     <li>current user id</li>
 *     <li>current user userName</li>
 *     <li>current user password</li>
 *     <li>current user firstName</li>
 *     <li>current user lastName</li>
 * </ul>
 * <p>id are the unique key to identify and differentiate the one user object  with another</p>
  *
  * */
@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger=LogManager.getLogger();
    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    private Page<User> getAllUser(Pageable page){
        return  userRepository.findAll(page);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private ResponseEntity<User> getUserByUsernameAndPassword(@RequestBody User userJson) {
        logger.info("Fetching the user by the username");
        User user = userRepository.login(userJson.getUserName());
        if(user!=null){
            logger.info("checking if the user enered password is same as in database");
            if(user.getPassword().equals(userJson.getPassword())){
                logger.info("if  password match  login is sucess");
                return new ResponseEntity<User>(user,HttpStatus.OK);
            }
            logger.info("password didnt match and returning null");
        }

        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {

        User user=  userRepository.getOne(id);
        if(user!=null){
            return new ResponseEntity<User>(user,HttpStatus.OK);
        }
        return  new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

}


