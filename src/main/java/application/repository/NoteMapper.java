package application.repository;

import application.entity.Note;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NoteMapper implements RowMapper<Note> {

    public NoteMapper() {
    }

    public Note mapRow(ResultSet resultSet, int i) throws SQLException {
        Note note = new Note();
        note.setId(resultSet.getLong("id"));
        note.setText(resultSet.getString("text"));
        note.setAvatar(resultSet.getString("avatar"));
        note.setDate(resultSet.getDate("date"));
        note.setUserName(resultSet.getString("user_name"));
        return note;
    }
}
