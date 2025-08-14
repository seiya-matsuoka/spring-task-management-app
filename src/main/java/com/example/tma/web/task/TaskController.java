package com.example.tma.web.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tma.domain.task.TaskService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

	private final TaskService taskService;

	@GetMapping
	public String showList(Model model) {
		model.addAttribute("taskList", taskService.findAll());
		return "tasks/list";
	}
}
