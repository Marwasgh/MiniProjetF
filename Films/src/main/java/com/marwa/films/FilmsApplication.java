package com.marwa.films;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marwa.films.entities.Film;
import com.marwa.films.service.FilmService;

@SpringBootApplication
public class FilmsApplication implements CommandLineRunner {
@Autowired
FilmService filmService;
public static void main(String[] args) {
SpringApplication.run(FilmsApplication.class, args);
}
@Override
public void run(String... args) throws Exception {
	/*filmService.saveFilm(new Film("sanam ", 2.1, new Date()));
	filmService.saveFilm(new Film("judhakbar", 3.0, new Date()));
	filmService.saveFilm(new Film(" abcd", 4.0, new Date()));*/
}}