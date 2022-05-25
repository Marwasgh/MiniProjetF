package com.marwa.films.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFilm;
	
	@NotNull
	@Size (min = 4,max = 50)
	private String nomFilm;
	@Min(value = 1)
	 @Max(value = 10)
	private Double dureeFilm;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateSortie;
	@ManyToOne
	private Genre genre;


	public Film() {
		super();
	}

	
	
	public Film(Long idFilm, String nomFilm, Double dureeFilm, Date dateSortie, Genre genre) {
		super();
		this.idFilm = idFilm;
		this.nomFilm = nomFilm;
		this.dureeFilm = dureeFilm;
		this.dateSortie = dateSortie;
		this.genre = genre;
	}

	public Long getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(Long idFilm) {
		this.idFilm = idFilm;
	}

	public String getNomFilm() {
		return nomFilm;
	}

	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}

	public Double getDureeFilm() {
		return dureeFilm;
	}

	public void setDureeFilm(Double dureeFilm) {
		this.dureeFilm = dureeFilm;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	@Override
	public String toString() {
		return "Film [idFilm=" + idFilm + ", nomFilm=" + nomFilm + ", dureeFilm=" + dureeFilm + ", dateSortie="
				+ dateSortie + ", genre=" + genre + "]";
	}



	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}




	public Film(String nomFilm, Double dureeFilm, Date dateSortie,Genre genre) {
		super();
		this.nomFilm = nomFilm;
		this.dureeFilm = dureeFilm;
		this.dateSortie = dateSortie;
		this.setGenre(genre);
	}

	public Film(String nomFilm, Double dureeFilm, Date dateSortie) {
		super();
		this.nomFilm = nomFilm;
		this.dureeFilm = dureeFilm;
		this.dateSortie = dateSortie;
	}
}
