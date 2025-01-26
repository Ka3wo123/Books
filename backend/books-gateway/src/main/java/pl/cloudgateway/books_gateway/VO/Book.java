package pl.cloudgateway.books_gateway.VO;

public record Book(Integer id, String title, String publishDate, Integer pageCount, Integer authorId) {}
