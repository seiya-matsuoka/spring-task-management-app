package com.example.tma.domain.task;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TaskRepository {

    @Select("select * from tasks")
    List<TaskEntity> findAll();
}
