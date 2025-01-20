package pl.graphql_intro;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.graphql_intro.model.Book;

@SpringBootTest
@AutoConfigureGraphQlTester
@AutoConfigureMockMvc
class BookControllerTest {

  @Autowired private GraphQlTester tester;

  @Autowired private MockMvc mockMvc;

  @Test
  public void getAllBooks() throws Exception {
    String query = "{ books {id name pageCount }";
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/graphql")
                .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"query\": \"" + query + "\"}")
                    .accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
  }

  @Test
  void canGetBooks() {
    tester.documentName("books").execute().path("books").entityList(Book.class).hasSize(3);
  }
}
