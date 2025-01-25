package pl.books.controller;

import org.springframework.web.bind.annotation.*;
import pl.books.model.Author;
import pl.books.service.AuthorService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @GetMapping
  public Flux<Author> getAuthors() {
    return authorService.getAuthors();
  }

  @GetMapping("/{id}")
  public Mono<Author> getAuthorById(@PathVariable("id") Integer id) {
    return authorService.getAuthorById(id);
  }
}
