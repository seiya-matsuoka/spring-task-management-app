package com.example.tma.web.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute TaskForm form) {
        return "tasks/creationForm";
    }

    @PostMapping
    public String create(@Validated TaskForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return showCreationForm(form);
        }
        taskService.create(form.getSummary(), form.getDescription());
        return "redirect:/tasks";
    }
}
