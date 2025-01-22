package pl.books.model;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

@Entity
public record Author(@Id Integer id, String name) {}
