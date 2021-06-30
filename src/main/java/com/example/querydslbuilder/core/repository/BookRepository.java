package com.example.querydslbuilder.core.repository;

import com.example.querydslbuilder.core.entity.Book;
import com.example.querydslbuilder.core.entity.QBook;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;

public interface BookRepository extends JpaRepository<Book, Long>
        , JpaSpecificationExecutor<Book>
        , QuerydslPredicateExecutor<Book>
        , QuerydslBinderCustomizer<QBook>
{

        @Override
        default void customize(final QuerydslBindings bindings, final QBook root) {
            bindings.bind(String.class)
                    .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
            bindings.excluding(root.name);
        }
}
