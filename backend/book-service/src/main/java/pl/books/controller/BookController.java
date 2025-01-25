package pl.books.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.books.model.Book;
import pl.books.service.BookService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/books")
public class BookController {
  private final BookService bookService;

  @Value("${eureka.client.service-url.defaultZone}")
  private String property;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping
  public Flux<Book> getBooks() {
    return bookService.getBooks();
  }

  @GetMapping("/config")
  public Mono<String> getConfig() {
    return Mono.just(property);
  }

  @GetMapping("/{id}")
  public Mono<Book> bookById(@RequestParam("id") Integer id) {
    return bookService.getBookById(id);
  }

  @PostMapping
  public Mono<Book> saveBook(Book book) {
    return bookService.save(book);
  }
}
