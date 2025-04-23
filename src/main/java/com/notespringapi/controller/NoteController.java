package com.notespringapi.controller;

import com.notespringapi.dto.NoteDto;
import com.notespringapi.dto.NotePatchDto;
import com.notespringapi.model.Note;
import com.notespringapi.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<Note> save(@Valid @RequestBody NoteDto noteDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(noteService.save(noteDto));
    }

    @GetMapping
    public ResponseEntity<List<NoteDto>> findAll() {
        return ResponseEntity.ok(noteService.findAll());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody NotePatchDto notePatchDto) {
        noteService.update(notePatchDto, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        noteService.delete(id);
        return ResponseEntity.ok().build();
    }
}
