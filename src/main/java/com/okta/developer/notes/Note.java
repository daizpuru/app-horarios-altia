package com.okta.developer.notes;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="text")
    private String text;

    @Column(name="user")
    @JsonIgnore
    private String user;


    public Note() {
    }

    public Note(String title, String user) {
        this.title = title;
        this.user = user;
    }

    public Note(Long id, String title, String text, String user) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.user = user;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Note id(Long id) {
        setId(id);
        return this;
    }

    public Note title(String title) {
        setTitle(title);
        return this;
    }

    public Note text(String text) {
        setText(text);
        return this;
    }

    public Note user(String user) {
        setUser(user);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Note)) {
            return false;
        }
        Note note = (Note) o;
        return Objects.equals(id, note.id) && Objects.equals(title, note.title) && Objects.equals(text, note.text) && Objects.equals(user, note.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, text, user);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", text='" + getText() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }
}
