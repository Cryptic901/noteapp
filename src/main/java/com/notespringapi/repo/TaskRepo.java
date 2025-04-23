package com.notespringapi.repo;

import com.notespringapi.model.Note;
import com.notespringapi.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepo extends MongoRepository<Task, String> {

}
