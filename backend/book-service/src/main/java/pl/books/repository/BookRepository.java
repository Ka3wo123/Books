package pl.books.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import pl.books.model.Book;

@Repository
public interface BookRepository extends R2dbcRepository<Book, Integer> {}
