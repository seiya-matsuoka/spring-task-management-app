package com.example.tma.domain.task;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TaskRepository {

    @Select("select * from tasks")
    List<TaskEntity> findAll();

    @Insert("insert into tasks (summary, description, priority, created_at) values (#{summary}, #{description}, #{priority}, CURRENT_TIMESTAMP)")
    void insert(String summary, String description, Integer priority);

    @Select("select * from tasks where id = #{taskId}")
    TaskEntity findById(long taskId);
}
