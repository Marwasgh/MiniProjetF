package com.marwa.films.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.marwa.films.entities.Film;
import com.marwa.films.entities.Genre;

public interface FilmService {
	Film saveFilm(Film f);
	Film updateFilm(Film f);
	void deleteFilm(Film f);
	void deleteFilmById(Long id);
	Film getFilm(Long id);
	List<Film> getAllFilms();
	 List<Genre> getAllGenres();
	List<Film> findByNomFilm(String nom);
	List<Film> findByNomFilmContains(String nom);
	List<Film> findByNomDuree (String nom, Double duree);
	List<Film> findByGenre (Genre genre);
	List<Film> findByGenreIdGenre(Long id);
	List<Film> findByOrderByNomFilmAsc();
	List<Film> trieFilmsNomsDuree();
	Page<Film> getAllFilmsParPage(int page, int size);
}
