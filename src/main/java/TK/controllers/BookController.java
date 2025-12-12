package TK.controllers;

import TK.entities.BookEntity;
import TK.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookEntityRepository bookRepository;

    public BookController(BookEntityRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public String getAllBooks(Model model) {
        List<BookEntity> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "bookList";
    }

    @GetMapping("/search")
    public String searchByAuthor(@RequestParam String author, Model model) {
        List<BookEntity> books = bookRepository.findByAuthor(author);
        model.addAttribute("books", books);
        return "bookList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new BookEntity());
        return "bookForm";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute BookEntity book) {
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        BookEntity book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        return "bookForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}