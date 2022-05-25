package com.marwa.films.service;

import java.util.List;



import org.springframework.data.domain.Page;

import com.marwa.films.entities.Genre;

public interface GenreService  {
	List <Genre> findAll();
	List<Genre> getAllGenres();
	Genre saveGenre(Genre genre);
	Page<Genre> getAllGenresParPage(int i, int j);
	void deleteGenreById(Long id);
	Genre getGenres(Long id);
	Genre updateGenres(Genre g);
}
