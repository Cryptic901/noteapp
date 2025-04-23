package com.notespringapi;

import org.springframework.boot.SpringApplication;
import org.testcontainers.utility.TestcontainersConfiguration;

public class TestNoteSpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.from(NoteSpringApiApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
