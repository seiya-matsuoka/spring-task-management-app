package com.example.tma.domain.task;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TaskRepository {

    @Select("select * from tasks")
    List<TaskEntity> findAll();

    @Insert("insert into tasks (summary, description) values (#{summary}, #{description})")
    void insert(String summary, String description);

    @Select("select * from tasks where id = #{taskId}")
    TaskEntity findById(long taskId);
}
