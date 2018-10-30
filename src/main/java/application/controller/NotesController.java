package application.controller;

import application.entity.Note;
import application.entity.User;
import application.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/")
public class NotesController {

    @Autowired
    private INoteService noteService;

    @Autowired
    private IUserService userService;

    @GetMapping()
    public String loadMainPage() {
        return "redirect:/notes";
    }

    @GetMapping("/notes")
    public String getNotesPage(Model model) {
        List<Note> notes = noteService.notesList(null);
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("notesList", notes);
        model.addAttribute("userName", userName);
        return "notes";
    }

    @PostMapping("/noteSearch")
    public String getNotesPageAsSearchResult(@RequestParam(value="searchString") String searchString, Model model) {
        List<Note> notes = noteService.notesList(searchString);
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("notesList", notes);
        model.addAttribute("userName", userName);
        model.addAttribute("searchString", searchString);
        return "search-result";
    }

    @GetMapping("/note")
    public String notePage() {
        return "note";
    }

    @PostMapping("/note")
    public String addNewNote(@RequestParam(value="id", required = false) Long id,
                             @RequestParam(value="text") String text) {

        if (id != null) {
            Note note = noteService.getNote(id);
            note.setText(text);
            noteService.update(note);
        } else {
            Note note = new Note();
            note.setText(text);
            noteService.create(note);
        }
        return "redirect:/notes";
    }

    @GetMapping("/note/{id}")
    public String editNote(@PathVariable Long id, Model model) {
        Note note = noteService.getNote(id);
        model.addAttribute("note", note);
        return "note";
    }

    @GetMapping("/deleteNote/{id}")
    public String deleteNote(@PathVariable Long id) {
        noteService.delete(id);
        return "redirect:/notes";
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMessage = null;
        if(error != null) {
            errorMessage = "Имя пользователя или пароль введены неверно";
        }
        if(logout != null) {
            errorMessage = "Выход выполнен успешно";
        }
        if (errorMessage != null) {
            model.addAttribute("errorMessage", errorMessage);
        }
        return "redirect:/notes";
    }

    @GetMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout=true";
    }

    @GetMapping("/user")
    public String getRegistrationPage() {
        return "user";
    }

    @PostMapping("/user")
    public String addNewUser(@RequestParam(value = "username") String userName,
                             @RequestParam(value = "password") String password, Model model) {
        User currentUser = null;
        try {
            currentUser = userService.getUserByName(userName);
        } catch (Exception e) {}
        if (currentUser != null) {
            model.addAttribute("error", "Пользователь с таким именем уже существует");
            return "user";
        }
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        userService.create(user);
        return "redirect:/notes";
    }
}
