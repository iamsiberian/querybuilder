package com.example.querydslbuilder.core.repository;

import com.example.querydslbuilder.core.entity.Book;
import com.example.querydslbuilder.core.service.querydsl.MyBookPredicatesBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

@ContextConfiguration(classes = TestConfigurationForJpaUnitTests.class)
public class BookRepositoryQueryDslTest extends BaseRepositoryTest {

    @Autowired
    private BookRepository repo;

    private Book bookJohn;
    private Book bookTom;

    @BeforeEach
    public void init() {
        bookJohn = new Book();
        bookJohn.setAuthor("John");
        bookJohn.setName("Book 1");
        repo.save(bookJohn);

        bookTom = new Book();
        bookTom.setAuthor("Tom");
        bookTom.setName("Book 2");
        repo.save(bookTom);
    }

    @Test
    public void givenLast_whenGettingListOfUsers_thenCorrect() {
        MyBookPredicatesBuilder builder = new MyBookPredicatesBuilder()
                .with("author", ":", "John");

        BooleanExpression booleanExpression = builder.build();

        Iterable<Book> results = repo.findAll(booleanExpression);
        assertThat(results, containsInAnyOrder(bookJohn));
    }

}
