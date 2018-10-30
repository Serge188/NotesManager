package application.repository;

import application.entity.Note;

import java.util.List;

public interface INoteDao {
    void create(Note note);
    void delete(Long id);
    void update(Note note);
    Note getNote(Long id);
    List<Note> notesList(String userName, String searchString);
}
