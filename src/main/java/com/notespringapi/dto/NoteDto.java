package com.notespringapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record NoteDto(
        @NotBlank(message = "Header shouldn't be empty")
        @Size(min = 1, max = 100, message = "Header must be between 1 and 100 characters")
        String title,
        String content,
        @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
        LocalDateTime creationDate) {
}
