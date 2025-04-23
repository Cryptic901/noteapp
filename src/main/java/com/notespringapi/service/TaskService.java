package com.notespringapi.service;

import com.notespringapi.dto.TaskDto;
import com.notespringapi.dto.TaskPatchDto;
import com.notespringapi.mapper.TaskMapper;
import com.notespringapi.model.Task;
import com.notespringapi.repo.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepo taskRepo;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepo taskRepo, TaskMapper taskMapper) {
        this.taskRepo = taskRepo;
        this.taskMapper = taskMapper;
    }

    public Task save(TaskDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.title());
        task.setCompleted(taskDto.completed());
        return taskRepo.save(task);
    }

    public List<TaskDto> findAll() {
        return taskRepo.findAll().stream().map(taskMapper::fromEntity).toList();
    }

    public void update(TaskPatchDto taskPatchDto, String id) {
        taskRepo.findById(id).ifPresent(note -> taskMapper.updateTask(taskPatchDto, note));
    }

    public void delete(String id) {
        taskRepo.findById(id).ifPresent(taskRepo::delete);
    }
}
