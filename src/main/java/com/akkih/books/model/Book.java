package com.akkih.books.model;

import com.akkih.books.serializing.LocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document(collection = "books")
public class Book {
    private @NotNull String id;
    private @NotNull String title;
    private @NotNull String author;
    private String genre;
    private double averageRating;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate publishedDate;

    @JsonCreator
    public Book(
            @JsonProperty("title") @NotNull String title,
            @JsonProperty("author") @NotNull String author,
            @JsonProperty("genre") String genre,
            @JsonProperty("publishedDate") LocalDate publishedDate,
            @JsonProperty("averageRating") double averageRating
    ) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishedDate = publishedDate;
        this.averageRating = averageRating;
    }

    public @NotNull String getId() {
        return id;
    }

    public void setId(@NotNull String id) {
        this.id = id;
    }

    public @NotNull String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    public @NotNull String getAuthor() {
        return author;
    }

    public void setAuthor(@NotNull String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}