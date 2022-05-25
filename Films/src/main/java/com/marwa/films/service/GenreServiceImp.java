package com.marwa.films.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.marwa.films.entities.Genre;
import com.marwa.films.repos.GenreRepository;

@Service
public class GenreServiceImp implements GenreService {

	@Override
	public List<Genre> findAll() {
	
		return genreRepository.findAll();
		
	}
	
	@Autowired
	GenreRepository genreRepository ;
	
	@Override
	public List<Genre> getAllGenres() {
		
		return genreRepository.findAll();
	}

	@Override
	public Genre saveGenre(Genre genre) {
		
		return genreRepository.save(genre);
	}

	@Override
	public Page<Genre> getAllGenresParPage(int page, int size) {
		
		return genreRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public void deleteGenreById(Long id) {
		genreRepository.deleteById(id);
		
	}

	@Override
	public Genre getGenres(Long id) {
		
		return genreRepository.findById(id).get();
	}

	@Override
	public Genre updateGenres(Genre g) {
		
		return genreRepository.save(g);
	}

}
