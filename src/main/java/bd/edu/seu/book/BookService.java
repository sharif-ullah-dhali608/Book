package bd.edu.seu.book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    public List<Book> listAll() {
        return bookRepository.findAll();
    }
    public Book get(int id) {
        return bookRepository.findById(id).orElse(null);
    }
    public void delete(int id) {
        bookRepository.deleteById(id);
    }
}
