package application.repository;

import application.entity.Note;

import javax.transaction.Transactional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class NoteDao implements INoteDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Note note) {
        String sql = "INSERT INTO notes (text, date, avatar, user_name) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, note.getText(), note.getDate(), note.getAvatar(), note.getUserName());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM notes WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void update(Note note) {
        String sql = "UPDATE notes SET text = ? WHERE id = ?";
        jdbcTemplate.update(sql, note.getText(), note.getId());
    }

    public Note getNote(Long id) {
        String sql = "SELECT * FROM notes WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new NoteMapper());
    }

    public List<Note> notesList(String userName, String searchString) {
        String sql = "SELECT * FROM notes WHERE user_name = ?";
        if (searchString != null) {
            sql = sql + " AND text LIKE ?";
            searchString = "%" + searchString + "%";
            return jdbcTemplate.query(sql, new NoteMapper(), userName, searchString);
        }
        return jdbcTemplate.query(sql, new NoteMapper(), userName);
    }
}
