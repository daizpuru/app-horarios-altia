package com.okta.developer.notes;

import java.security.Principal;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    Logger logger = Logger.getLogger("UserController");    

    @Autowired
    NotesRepository notesRepository;

    @GetMapping("/user/notes")
    public Page<Note> notes(Principal principal, String title, Pageable pageable) {

        logger.info("Recuperando notas del usuario: "+principal.getName());

        if (title == null || title.isEmpty()) {
            return notesRepository.findAllByUser(principal.getName(), pageable);
        } else {
            return notesRepository.findAllByUserAndTitleContainingIgnoreCase(principal.getName(), title, pageable);
        }
    }

    @GetMapping("/user")
    public OidcUser user(@AuthenticationPrincipal OidcUser user) {
        return user;
    }
    
}
