package pl.books.service;

import org.springframework.stereotype.Service;
import pl.books.model.Book;
import pl.books.repository.BookRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Flux<Book> getBooks() {
        return bookRepository.findAll();
    }
    public Mono<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    public Mono<Book> save(Book book) {
        return bookRepository.save(book);
    }
}
