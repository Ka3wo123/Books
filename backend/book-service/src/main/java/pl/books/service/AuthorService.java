package pl.books.service;

import org.springframework.stereotype.Service;
import pl.books.model.Author;
import pl.books.repository.AuthorRepository;
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
