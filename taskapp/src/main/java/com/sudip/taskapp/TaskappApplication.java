package com.sudip.taskapp;



import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskappApplication {
    private static Logger logger = LogManager.getLogger();

   // private  static org.apache.logging.log4j.Logger log2=LogManager.getLogger();
    public static void main(String[] args) {
        logger.log(Level.getLevel("DIAG"),"Application started");

//        SpringApplication.run(TaskappApplication.class, args);
//        logger.info("Application terminated");
    }
}
