package com.example.gutendexclient.controller;

import com.example.gutendexclient.model.Author;
import com.example.gutendexclient.model.Book;
import com.example.gutendexclient.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class BookController {
    @Autowired
    private BookService bookService;

    public void run(Scanner scanner) {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("--------------*-MadeByDavidMoya-*------------");
            System.out.println("Gracias por utilizar mi Aplicacion");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Listar libros por idioma");
            System.out.println("4. Mostrar cantidad de libros por idioma");
            System.out.println("5. Listar autores vivos en un año específico");
            System.out.println("6. Mostrar top 10 libros más descargados");
            System.out.println("7. Mostrar estadísticas de descargas");
            System.out.println("8. Salir");


            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.println("Ingrese el título del libro:");
                    String title = scanner.nextLine();
                    Optional<Book> book = bookService.searchBookByTitle(title);
                    if (book.isPresent()) {
                        System.out.println("Libro encontrado: " + book.get());
                    } else {
                        System.out.println("Libro no encontrado");
                    }
                    break;
                case 2:
                    List<Book> books = bookService.getAllBooks();
                    books.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Ingrese el idioma del libro:");
                    String language = scanner.nextLine();
                    List<Book> booksByLanguage = bookService.getBooksByLanguage(language);
                    booksByLanguage.forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Ingrese el idioma:");
                    String lang = scanner.nextLine();
                    long count = bookService.countBooksByLanguage(lang);
                    System.out.println("Cantidad de libros en " + lang + ": " + count);
                    break;
                case 5:
                    System.out.println("Ingrese el año:");
                    int year = Integer.parseInt(scanner.nextLine());
                    List<Author> authors = bookService.getAuthorsAliveInYear(year);
                    authors.forEach(System.out::println);
                    break;
                case 6:
                    List<Book> topBooks = bookService.getTopDownloadedBooks(10);
                    topBooks.forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("Estadísticas de descargas:");
                    System.out.println(bookService.getDownloadStatistics());
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
