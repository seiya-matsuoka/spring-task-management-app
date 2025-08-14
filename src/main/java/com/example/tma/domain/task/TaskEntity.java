package com.example.tma.domain.task;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TaskEntity {
	 private long id;
	 private String summary;
	 private String description;
}
