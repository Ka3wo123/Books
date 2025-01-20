package pl.graphql_intro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;
import pl.graphql_intro.model.Book;

@SpringBootTest
@AutoConfigureGraphQlTester
class BookControllerTest {

  @Autowired private GraphQlTester tester;

  @Test
  void canGetBooks() {
    tester.documentName("books").execute().path("books").entityList(Book.class).hasSize(3);
  }
}
