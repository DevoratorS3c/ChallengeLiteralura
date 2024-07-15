package com.example.gutendexclient.service;

import com.example.gutendexclient.model.Author;

import com.example.gutendexclient.model.Book;
import com.example.gutendexclient.repository.IAuthorRepository;
import com.example.gutendexclient.repository.IBookRepository;
import com.example.gutendexclient.util.GutendexApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IAuthorRepository authorRepository;

    private GutendexApiClient apiClient = new GutendexApiClient();

    public Optional<Book> searchBookByTitle(String title) {
        return apiClient.fetchBookByTitle(title).map(book -> {
            Author author = book.getAuthor();
            if (author != null) {
                author = authorRepository.save(author);
                book.setAuthor(author);
            }
            return bookRepository.save(book);
        });
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByLanguage(String language) {
        return bookRepository.findBooksByLanguage(language);
    }

    public long countBooksByLanguage(String language) {
        return bookRepository.findBooksByLanguage(language).stream().count();
    }

    public List<Author> getAuthorsAliveInYear(int year) {
        return authorRepository.findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(year,year);
    }

    public List<Book> getTopDownloadedBooks(int top) {
        return bookRepository.findAll().stream()
                .sorted(Comparator.comparingInt(Book::getDownloadCount).reversed())
                .limit(top)
                .collect(Collectors.toList());
    }

    public DoubleSummaryStatistics getDownloadStatistics() {
        return bookRepository.findAll().stream()
                .mapToDouble(Book::getDownloadCount)
                .summaryStatistics();
    }
}