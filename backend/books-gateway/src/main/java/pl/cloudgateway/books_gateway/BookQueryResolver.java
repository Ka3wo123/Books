package pl.cloudgateway.books_gateway;

import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pl.cloudgateway.books_gateway.VO.Author;
import pl.cloudgateway.books_gateway.VO.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class BookQueryResolver implements GraphQLQueryResolver {
  private final DiscoveryClient discoveryClient;

  public BookQueryResolver(DiscoveryClient discoveryClient) {
    this.discoveryClient = discoveryClient;
  }

  public Flux<Book> books() {
    WebClient webClient = createWebClient("book-service");
    return webClient.get().uri("/api/books").retrieve().bodyToFlux(Book.class);
  }

  public Flux<Author> authors() {
    WebClient webClient = createWebClient("book-service");
    return webClient.get().uri("/api/authors").retrieve().bodyToFlux(Author.class);
  }

  public Mono<Author> authorById(Integer id) {
    WebClient webClient = createWebClient("book-service");
    return webClient
        .get()
        .uri(String.format("/api/authors/%s", id))
        .retrieve()
        .bodyToMono(Author.class);
  }

  public Mono<Author> saveAuthor(Author author) {
    WebClient webClient = createWebClient("book-service");
    return webClient
        .post()
        .uri("/api/authors")
        .bodyValue(author)
        .retrieve()
        .bodyToMono(Author.class);
  }

  public Mono<Book> saveBook(Book book) {
    WebClient webClient = createWebClient("book-service");
    return webClient.post().uri("/api/books").bodyValue(book).retrieve().bodyToMono(Book.class);
  }

  private WebClient createWebClient(String serviceName) {
    List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
    if (instances.isEmpty()) {
      throw new RuntimeException("No service available: " + serviceName);
    }
    return WebClient.create(instances.get(0).getUri().toString());
  }
}
