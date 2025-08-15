package com.example.tma.domain.task;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TaskEntity {
	 private long id;
	 private String summary;
	 private String description;
	 private Integer priority;
	 private LocalDateTime createdAt;
}
