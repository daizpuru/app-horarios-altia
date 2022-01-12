package com.okta.developer.notes;

import java.util.logging.Logger;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationRunner {

    Logger logger = Logger.getLogger("DataInitializer");

    @Autowired
    NotesRepository notesRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        IntStream.range(0, 1000).forEachOrdered(n -> {
            notesRepository.save(new Note("Note " + n, "daizpuru@gmail.com"));
        });
        logger.info("1000 notes created!");
        logger.info("Notes initialization complete!");
    }

}
