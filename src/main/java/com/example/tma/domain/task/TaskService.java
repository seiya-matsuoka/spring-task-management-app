package com.example.tma.domain.task;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

	private final TaskRepository taskRepository;

	public List<TaskEntity> findAll(String sort, String dir) {

		String normalizedSort = (sort == null || sort.isBlank()) ? "createdAt" : sort;
		String normalizedDir = (dir == null || dir.isBlank()) ? "asc" : dir.toLowerCase();

		Set<String> allowedSorts = Set.of("createdAt", "summary", "priority");
		if (!allowedSorts.contains(normalizedSort)) {
			normalizedSort = "createdAt";
		}

		if (!normalizedDir.equals("asc") && !normalizedDir.equals("desc")) {
			normalizedDir = "asc";
		}

		return taskRepository.findAll(normalizedSort, normalizedDir);
	}

	@Transactional
	public void create(String summary, String description, Integer priority) {
		taskRepository.insert(summary, description, priority);
	}

	public TaskEntity findById(long taskId) {
		return taskRepository.findById(taskId);
	}
}
