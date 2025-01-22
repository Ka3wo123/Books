package pl.books.model;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

@Entity
public record Book(@Id Integer id, String name, Integer pageCount, Integer authorId) {

}
