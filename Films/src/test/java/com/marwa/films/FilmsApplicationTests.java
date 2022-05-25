package com.marwa.films;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.marwa.films.entities.Film;
import com.marwa.films.entities.Genre;
import com.marwa.films.repos.FilmRepository;
import com.marwa.films.service.FilmService;

@SpringBootTest
class FilmsApplicationTests {

	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private FilmService filmService;
	/*@Test
	public void testCreateFilm() {
	Film f = new Film("Ai dil hai mushkil",2.3,new Date());
	filmRepository.save(f);
	}*/
	
	@Test
	public void testFindFilm()
	{
		Film f = filmRepository.findById(1L).get();

	System.out.println(f);
	}
	@Test
	public void testUpdateFilm()
	{
	Film f = filmRepository.findById(1L).get();
	f.setDureeFilm(1000.0);
	filmRepository.save(f);
	}
	@Test
	public void testDeleteFilm()
	{
		filmRepository.deleteById(1L);;
	}
	@Test
	public void testListerTousFilms()
	{
	List<Film> films = filmRepository.findAll();
	for (Film f : films)
	{
	System.out.println(f);
	}}
	

	@Test
	public void testFindByNomFilm()
	{
	List<Film> films = filmRepository.findByNomFilm("hai");
	for (Film f : films)
	{
	System.out.println(f);
	}
	}
	
	@Test
	public void testfindByNomDuree()
	{
	List<Film> films = filmRepository.findByNomDuree("ai dil", 2.5);
	for (Film f : films)
	{
	System.out.println(f);
	}
	}

	@Test
	public void testfindByGenre()
	{
	Genre g = new Genre();
	g.setIdGenre(1L);
	List<Film> films = filmRepository.findByGenre(g);
	for (Film f : films)
	{
	System.out.println(f);
	}
	}

	@Test
	public void testfindByGenreIdGenre()
	{
	List<Film> films = filmRepository.findByGenreIdGenre(1L);
	for (Film f : films)
	{
	System.out.println(f);
	}
	 }
	
	@Test
	public void testfindByOrderByNomFilmAsc()
	{
	List<Film> films = filmRepository.findByOrderByNomFilmAsc();
	for (Film f :films)
	{
	System.out.println(f);
	}
	}
	
	@Test
	public void testtrierFilmsNomsDuree()
	{
	List<Film> films = filmRepository.trierFilmsNomsDuree();
	for (Film f : films)
	{
	System.out.println(f);
	}
	}
	
	@Test
	public void testFindByNomFilmContains()
	{
	Page<Film> films = filmService.getAllFilmsParPage(0,2);
	System.out.println(films.getSize());
	System.out.println(films.getTotalElements());
	System.out.println(films.getTotalPages());
	films.getContent().forEach(f -> {System.out.println(f.toString());
	});
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}


}
