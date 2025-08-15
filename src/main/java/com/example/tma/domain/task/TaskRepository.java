package com.example.tma.domain.task;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TaskRepository {

    @Select("""
            <script>
            SELECT id, summary, description, priority, created_at
            FROM tasks
            <choose>
              <when test="sort == 'summary'">
                ORDER BY summary
              </when>
              <when test="sort == 'priority'">
                ORDER BY priority
              </when>
              <otherwise>
                ORDER BY created_at
              </otherwise>
            </choose>
            <choose>
              <when test="dir == 'asc'">
                ASC
              </when>
              <otherwise>
                DESC
              </otherwise>
            </choose>
            </script>
            """)
        List<TaskEntity> findAll(@Param("sort") String sort, @Param("dir") String dir);

    @Insert("insert into tasks (summary, description, priority, created_at) values (#{summary}, #{description}, #{priority}, CURRENT_TIMESTAMP)")
    void insert(String summary, String description, Integer priority);

	@Select("select * from tasks where id = #{taskId}")
	TaskEntity findById(long taskId);
}
