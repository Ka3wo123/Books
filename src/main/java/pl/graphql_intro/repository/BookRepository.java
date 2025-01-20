package pl.graphql_intro.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import pl.graphql_intro.model.Book;

@Repository
public interface BookRepository extends R2dbcRepository<Book, Integer> {}
