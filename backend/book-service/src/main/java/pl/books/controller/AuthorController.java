package pl.books.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import pl.books.model.Author;
import pl.books.service.AuthorService;
import reactor.core.publisher.Mono;

@Controller
public class AuthorController {
  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @MutationMapping
  public Mono<Author> saveAuthor(@Argument Author author) {
    return authorService.save(author);
  }
}
