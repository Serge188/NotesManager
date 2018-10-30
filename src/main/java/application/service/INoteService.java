package application.service;

import application.entity.Note;

import java.util.List;

public interface INoteService {
    void create(Note note);
    void delete(Long id);
    void update(Note note);
    Note getNote(Long id);
    List<Note> notesList(String searchString);
}
