package com.example.tma.domain.task;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

	private final TaskRepository taskRepository;

	public List<TaskEntity> findAll() {
		return taskRepository.findAll();
	}

	@Transactional
    public void create(String summary, String description) {
		taskRepository.insert(summary, description);
    }
}
