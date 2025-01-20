package pl.graphql_intro.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import pl.graphql_intro.model.Author;
import pl.graphql_intro.model.Book;
import pl.graphql_intro.service.AuthorService;
import pl.graphql_intro.service.BookService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class BookController {
  private final BookService bookService;
  private final AuthorService authorService;

  public BookController(BookService bookService, AuthorService authorService) {
    this.bookService = bookService;
    this.authorService = authorService;
  }

  @QueryMapping
  public Flux<Book> books() {
    return bookService.getBooks();
  }

  @QueryMapping
  public Mono<Book> bookById(@Argument Integer id) {
    return bookService.getBookById(id);
  }

  @SchemaMapping
  public Mono<Author> author(Book book) {
    return authorService.getAuthorById(book.authorId());
  }

  @MutationMapping
  public Mono<Book> saveBook(@Argument Book book) {
    return bookService.save(book);
  }
}
