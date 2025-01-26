package pl.cloudgateway.books_gateway.VO;

public record Book(Integer id, String title, Integer publishDate, Integer pageCount, Integer authorId) {}
