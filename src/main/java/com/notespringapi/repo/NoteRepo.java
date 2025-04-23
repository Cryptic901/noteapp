package com.notespringapi.repo;

import com.notespringapi.dto.NoteDto;
import com.notespringapi.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoteRepo extends MongoRepository<Note, String> {
}
