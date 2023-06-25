package com.akkih.books.repository;

import com.akkih.books.model.Book;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends MongoRepository<Book, UUID> {
    @NotNull Optional<Book> findById(@NotNull String id);
}