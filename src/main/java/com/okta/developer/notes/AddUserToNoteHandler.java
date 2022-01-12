package com.okta.developer.notes;

import java.util.logging.Logger;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Note.class)
public class AddUserToNoteHandler {

    Logger logger = Logger.getLogger("AddUserToNoteHandler");

    @HandleBeforeCreate
    public void handleNoteBeforeCreate(Note note) {
        logger.info("Inside Note Before Create....");
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("Creating note " + note + " for user " + userName);
        note.setUser(userName);
    }

}
