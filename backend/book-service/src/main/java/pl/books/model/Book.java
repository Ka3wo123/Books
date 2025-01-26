package pl.books.model;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

@Entity
public record Book(@Id Integer id, String title, String publishDate, Integer pageCount, Integer authorId) {

}
