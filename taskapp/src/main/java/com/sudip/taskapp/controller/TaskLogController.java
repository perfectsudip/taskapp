package com.sudip.taskapp.controller;

import com.sudip.taskapp.model.TaskLog;
import com.sudip.taskapp.repository.TaskLogRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *TaskLogConroller is a class  that performs all  tasklog context functionality
 *
 */
@RestController
@RequestMapping("/task")
public class TaskLogController {
    private static  final Logger logger=LogManager.getLogger();
    @Autowired
    TaskLogRepository taskLogRepository;

    /*
    * Get all the  Task log which are  stored in our tak log database. If no data are found  null tasklog is fetched.
    *
    * */

    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public List<TaskLog> getAllTaskLog(){
        logger.info("tasklogRepo: findAll() : START");
        return   taskLogRepository.findAll();

    }

    /* Saves the tasklog  object to the database.
      * @RequestBody   indicates  method parameter to be bound to the body of the web request
      * @param tasklog tasklog  object that is recieved from the web request
      * @return  tasklog object if the tasklog is saved successfully saved to the database
      * */

    @RequestMapping(value = "/save" ,method = RequestMethod.POST)
    public TaskLog saveTaskLog(@RequestBody TaskLog taskLog){
        logger.info("TaskLogController: saveTaskLog() : save() ");
        return taskLogRepository.save(taskLog);

    }

    /*
    * Get a Tasklog object As per tasklog id.
     *@PathVariable       indicates variable sent along  the api  url
     *@param id           id of the tasklog
     *@return             tasklog object that matches the @param id
     */
    @RequestMapping(value = "/getById/{id}" ,method = RequestMethod.GET)
    public TaskLog getTaskLogById(@PathVariable Integer id){
       logger.info("Task log is fetched according to the id ");
        return   taskLogRepository.getOne(id);
    }



}
