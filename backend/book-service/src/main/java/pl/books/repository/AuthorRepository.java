package pl.books.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import pl.books.model.Author;

@Repository
public interface AuthorRepository extends R2dbcRepository<Author, Integer> {}
