package application.service;

import application.entity.Note;
import application.repository.INoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteService implements INoteService {

    @Autowired
    private INoteDao noteDao;

    public void create(Note note) {
        if (note != null) {
            Date now = new Date();
            String avatar = String.format("https://avatars.dicebear.com/v2/identicon/%d.svg", now.getTime());
            String userName = SecurityContextHolder.getContext().getAuthentication().getName();

            note.setDate(now);
            note.setAvatar(avatar);
            note.setUserName(userName);
            noteDao.create(note);
        }
    }

    public void delete(Long id) {
        noteDao.delete(id);
    }

    public void update(Note note) {
        noteDao.update(note);
    }

    public Note getNote(Long id) {
        return noteDao.getNote(id);
    }

    public List<Note> notesList(String searchString) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Note> noteList = noteDao.notesList(userName, searchString);
        noteList.forEach(note -> {
            if (note.getText().length() > 25) {
                note.setShortText(note.getText().substring(0, 24) + "...");
            } else {
                note.setShortText(note.getText());
            }
        });
        return noteList;
    }
}
