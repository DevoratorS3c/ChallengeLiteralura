package com.example.gutendexclient;

import com.example.gutendexclient.controller.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class GutendexClientApplication implements CommandLineRunner {

	@Autowired
	private BookController bookController;

	public static void main(String[] args) {
		SpringApplication.run(GutendexClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		bookController.run(scanner);
	}
}