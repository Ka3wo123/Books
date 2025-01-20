package pl.graphql_intro.service;

import org.springframework.stereotype.Service;
import pl.graphql_intro.model.Author;
import pl.graphql_intro.repository.AuthorRepository;
import reactor.core.publisher.Mono;

@Service
public class AuthorService {
  private final AuthorRepository authorRepository;

  public AuthorService(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public Mono<Author> getAuthorById(Integer id) {
    return authorRepository.findById(id);
  }


  public Mono<Author> save(Author author) {
    return authorRepository.save(author);
  }
}
