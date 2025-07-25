package bd.edu.seu.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    @Autowired
    private  BookService bookService;

    @GetMapping("/")
    public String page(){
        return "book-list";
    }

    @GetMapping("/books")
    public String viewHomePage(Model model) {
        model.addAttribute("books", bookService.listAll());
        return "book-list";
    }

    @PostMapping("/books")
    public String createBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        Book book = bookService.get(id);
        model.addAttribute("book", book);
        return "edit-book";
    }

    @PostMapping("/books/update")
    public String updateBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/books";
    }


    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}


