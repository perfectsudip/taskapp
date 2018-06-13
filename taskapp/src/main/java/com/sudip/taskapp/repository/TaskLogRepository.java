package com.sudip.taskapp.repository;

import com.sudip.taskapp.model.TaskLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskLogRepository extends JpaRepository<TaskLog ,Integer> {
//    @Query("SELECT t from Tasklog t WHERE t.user.userId= :uId" )
//    public  TaskLog getByUserId(@Param("uId") Integer uId);
}
