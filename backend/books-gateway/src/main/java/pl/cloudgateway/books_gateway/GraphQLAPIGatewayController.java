package pl.cloudgateway.books_gateway;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cloudgateway.books_gateway.VO.Author;
import pl.cloudgateway.books_gateway.VO.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class GraphQLAPIGatewayController {
  private final BookQueryResolver resolver;

  public GraphQLAPIGatewayController(BookQueryResolver resolver) {
    this.resolver = resolver;
  }

  @QueryMapping
  public Flux<Book> books() {
    return resolver.books();
  }

  @QueryMapping
  public Flux<Author> authors() {
    return resolver.authors();
  }

  @SchemaMapping
  public Mono<Author> author(Book book) {
    return resolver.authorById(book.authorId());
  }
}
