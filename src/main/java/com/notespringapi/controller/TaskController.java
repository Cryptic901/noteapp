package com.notespringapi.controller;

import com.notespringapi.dto.TaskDto;
import com.notespringapi.dto.TaskPatchDto;
import com.notespringapi.model.Task;
import com.notespringapi.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> save(@Valid @RequestBody TaskDto taskDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(taskService.save(taskDto));
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody TaskPatchDto taskPatchDto) {
        taskService.update(taskPatchDto, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }
}
