package com.notespringapi.mapper;

import com.notespringapi.dto.TaskDto;
import com.notespringapi.dto.TaskPatchDto;
import com.notespringapi.model.Task;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto fromEntity(Task task);
    Task toEntity(TaskDto taskDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTask(TaskPatchDto taskPatchDto, @MappingTarget Task task);
}
