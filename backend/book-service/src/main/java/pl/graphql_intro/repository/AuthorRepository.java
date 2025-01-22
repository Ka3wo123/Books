package pl.graphql_intro.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import pl.graphql_intro.model.Author;

@Repository
public interface AuthorRepository extends R2dbcRepository<Author, Integer> {}
