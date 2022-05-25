package com.marwa.films.entities;
/*
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Genre {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idGenre;
private String nomGenre;
private String descriptionGenre;
@OneToMany(mappedBy = "genre")
private List<Film> films;
public Genre() {}
public Genre(String nomGenre, String descriptionGenre, List<Film> films)
{
super();
this.nomGenre = nomGenre;
this.descriptionGenre = descriptionGenre;
this.films = films;
}
public Long getIdGenret() {
return idGenre;
}
public void setIdGenre(Long idGenre) {
this.idGenre = idGenre;
}
public String getNomGenre() {
return nomGenre;
}
public void setNomGenre(String nomGenre) {
this.nomGenre = nomGenre;
}
public String getDescriptionGenre() {
return descriptionGenre;
}
public void setDescriptionGenre(String descriptionGenre) {
this.descriptionGenre = descriptionGenre;
}
public List<Film> getFilms() {
return films;
}
public void setFilms(List<Film> films) {
this.films = films;
}
}*/


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Genre {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idGenre;
private String nomGenre;
private String descriptionGenre;
@JsonIgnore
@OneToMany(mappedBy = "genre")
private List<Film> films;
@Override
public String toString() {
	return "Genre [idGenre=" + idGenre + ", nomGenre=" + nomGenre + ", descriptionGenre=" + descriptionGenre
			+ ", films=" + films + "]";
}
public Long getIdGenret() {
return idGenre;
}
public void setIdGenre(Long idGenre) {
this.idGenre = idGenre;
}
public String getNomGenre() {
return nomGenre;
}
public void setNomGenre(String nomGenre) {
this.nomGenre = nomGenre;
}
}