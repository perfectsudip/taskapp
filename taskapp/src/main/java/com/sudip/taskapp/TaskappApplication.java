package com.sudip.taskapp;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskappApplication {
    public final static Logger logger=LogManager.getLogger(TaskappApplication.class);

    public static void main(String[] args) {
        logger.info("applicatioon started");
        SpringApplication.run(TaskappApplication.class, args);
    }
}
