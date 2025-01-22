package pl.graphql_intro.service;

import org.springframework.stereotype.Service;
import pl.graphql_intro.model.Book;
import pl.graphql_intro.repository.BookRepository;
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
