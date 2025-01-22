package pl.graphql_intro.model;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

@Entity
public record Book(@Id Integer id, String name, Integer pageCount, Integer authorId) {

}
