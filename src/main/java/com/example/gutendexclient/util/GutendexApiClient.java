package com.example.gutendexclient.util;

import com.example.gutendexclient.model.Author;
import com.example.gutendexclient.model.Book;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class GutendexApiClient {
    private static final String BASE_URL = "https://gutendex.com/books/";

    public Optional<Book> fetchBookByTitle(String title) {
        String url = BASE_URL + "?search=" + title;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == HttpURLConnection.HTTP_OK) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode rootNode = mapper.readTree(response.body());
                JsonNode bookNode = rootNode.path("results").get(0);

                if (bookNode != null) {
                    Book book = new Book();
                    book.setTitle(bookNode.path("title").asText());
                    book.setLanguage(bookNode.path("languages").get(0).asText());
                    book.setDownloadCount(bookNode.path("download_count").asInt());

                    JsonNode authorNode = bookNode.path("authors").get(0);
                    if (authorNode != null) {
                        Author author = new Author();
                        author.setName(authorNode.path("name").asText());
                        author.setBirthYear(authorNode.path("birth_year").asInt());
                        author.setDeathYear(authorNode.path("death_year").asInt());
                        book.setAuthor(author);
                    }

                    return Optional.of(book);
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
