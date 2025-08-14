package com.example.tma.domain.task;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

	private final TaskRepository taskRepository;

	public List<TaskEntity> findAll() {
		return taskRepository.findAll();
	}
}
