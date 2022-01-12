package com.okta.developer.notes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface NotesRepository extends JpaRepository<Note, Long> {
    
    Page<Note> findAllByUser(String name, Pageable pageable);

    Page<Note> findAllByUserAndTitleContainingIgnoreCase(String name, String title, Pageable pageable);
}
