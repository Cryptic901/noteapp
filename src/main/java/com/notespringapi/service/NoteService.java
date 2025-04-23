package com.notespringapi.service;

import com.notespringapi.dto.NoteDto;
import com.notespringapi.dto.NotePatchDto;
import com.notespringapi.mapper.NoteMapper;
import com.notespringapi.model.Note;
import com.notespringapi.repo.NoteRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {

    private final NoteRepo noteRepo;
    private final NoteMapper noteMapper;

    public NoteService(NoteRepo noteRepo,
                       NoteMapper noteMapper) {
        this.noteRepo = noteRepo;
        this.noteMapper = noteMapper;
    }

    public Note save(NoteDto noteDto) {
        Note note = new Note();
        note.setTitle(noteDto.title());
        note.setContent(noteDto.content());
        note.setCreationDate(noteDto.creationDate());
        return noteRepo.save(note);
    }

    public List<NoteDto> findAll() {
        return noteRepo.findAll().stream().map(noteMapper::fromEntity).toList();
    }

    public void update(NotePatchDto notePatchDto, String id) {
        noteRepo.findById(id).ifPresent(note -> noteMapper.updateNoteFromDto(notePatchDto, note));
    }

    public void delete(String id) {
        noteRepo.findById(id).ifPresent(noteRepo::delete);
    }
}


