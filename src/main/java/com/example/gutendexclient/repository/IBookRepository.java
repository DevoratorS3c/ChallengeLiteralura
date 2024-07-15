package com.example.gutendexclient.repository;

import com.example.gutendexclient.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Long> {
    List<Book> findByLanguage(String language);

    @Query("SELECT b FROM Book b WHERE b.language = ?1")
    List<Book> findBooksByLanguage(String language);
}
