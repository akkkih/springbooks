package com.akkih.books.service;

import com.akkih.books.model.Book;
import com.akkih.books.repository.BookRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(String id) {
        return bookRepository
                .findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Couldn't find book with id: " + id)
                );
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(String id, @NotNull Book updatedBook) {
        Book existingBook = getBookById(id);
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setGenre(updatedBook.getGenre());
        existingBook.setPublishedDate(updatedBook.getPublishedDate());
        existingBook.setAverageRating(updatedBook.getAverageRating());

        return bookRepository.save(existingBook);
    }

    public void deleteBook(String id) {
        bookRepository.delete(getBookById(id));
    }
}