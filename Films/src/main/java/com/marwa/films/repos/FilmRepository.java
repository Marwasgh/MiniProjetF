package com.marwa.films.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.marwa.films.entities.Film;
import com.marwa.films.entities.Genre;
@RepositoryRestResource(path = "rest")
public interface FilmRepository extends JpaRepository<Film, Long> {
	 @Query("select f from Film f  where f.nomFilm like 'ai'")
	 List<Film> findByNomFilm(@Param("nomF") String nom);
	 
	/*@Query("select f from Film f where f.nomFilm like %?1 and f.dureeFilm > ?2")
	List<Film> findByNomDuree (String nom, Double duree);*/
	
	@Query("select f from Film f where f.nomFilm like %:nom and f.dureeFilm > :duree")
	List<Film> findByNomDuree (@Param("nom") String nom,@Param("duree") Double duree);
	
	List<Film> findByNomFilmContains(String nom);
	 
	 @Query("select f from Film f where f.genre = ?1")
	 List<Film> findByGenre (Genre genre);
	 
	 
	 List<Film> findByGenreIdGenre( Long id);

	 List<Film> findByOrderByNomFilmAsc();
	 
	 @Query("select f from Film f order by f.nomFilm ASC, f.dureeFilm DESC")
		List<Film> trierFilmsNomsDuree ();

	 
}
