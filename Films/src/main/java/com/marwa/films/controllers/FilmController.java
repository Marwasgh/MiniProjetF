package com.marwa.films.controllers;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marwa.films.entities.Film;
import com.marwa.films.entities.Genre;
import com.marwa.films.service.FilmService;
import com.marwa.films.service.GenreService;

@Controller
public class FilmController {
	@Autowired
	FilmService filmService;
	
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		List<Genre> gs = filmService.getAllGenres();
		Film film = new Film();
		Genre g = new Genre();
		g = gs.get(0); // prendre la première catégorie de la liste
		film.setGenre(g); //affedter une catégorie par défaut au produit pour éviter le pb avec une catégorie null
		
		modelMap.addAttribute("film", film);
	modelMap.addAttribute("mode", "new");
	modelMap.addAttribute("genres", gs);
	return "formFilm";
	}
	
	
	@RequestMapping("/saveFilm")
	public String saveFilm(@Valid Film film, BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formFilm";

	filmService.saveFilm(film);
	return "redirect:/ListeFilms";
	}


/*
@RequestMapping("/saveFilm")
public String saveFilm(@ModelAttribute("film") Film film,
 @RequestParam("date") String date,
 ModelMap modelMap) throws
ParseException
{
//conversion de la date
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateSortie = dateformat.parse(String.valueOf(date));
 film.setDateSortie(dateSortie);

Film saveFilm = filmService.saveFilm(film);
String msg ="film enregistré avec Id "+saveFilm.getIdFilm();
modelMap.addAttribute("msg", msg);
return "createFilm";
}
@RequestMapping("/saveFilm")
public String saveFilm(@ModelAttribute("film") Film film)
{
 filmService.saveFilm(film);
return "createFilm";
}*/
/*
@RequestMapping("/ListeFilms")
public String listeFilms(ModelMap modelMap)
{
List<Film> f = filmService.getAllFilms();
modelMap.addAttribute("films", f);
return "listeFilms";
}
@RequestMapping("/ListeFilms")
public String listeFilms(ModelMap modelMap,

@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)

{
Page<Film> films = filmService.getAllFilmsParPage(page, size);
modelMap.addAttribute("produits", films);

modelMap.addAttribute("pages", new int[films.getTotalPages()]);

modelMap.addAttribute("currentPage", page);
return "listeFilms";
}
*/
	@RequestMapping("/ListeFilms")
	public String listeFilms(ModelMap modelMap,

	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)

	{
	Page<Film> fl = filmService.getAllFilmsParPage(page, size);
	List<Genre> gs=genreService.getAllGenres();
	modelMap.addAttribute("films", fl);
	modelMap.addAttribute("genres", gs);

	modelMap.addAttribute("pages", new int[fl.getTotalPages()]);

	modelMap.addAttribute("currentPage", page);
	return "listeFilms";
	}	
/*@RequestMapping("/supprimerFilm")
public String supprimerFilm(@RequestParam("id") Long id,
 ModelMap modelMap)
{
	filmService.deleteFilmById(id);
List<Film> f = filmService.getAllFilms();
modelMap.addAttribute("films", f);
return "listeFilms";
}*/
	@RequestMapping("/supprimerFilm")
	public String supprimerFilm(@RequestParam("id") Long id,

	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)

	{
	filmService.deleteFilmById(id);
	Page<Film> fl = filmService.getAllFilmsParPage(page,size);

	modelMap.addAttribute("films", fl);
	modelMap.addAttribute("pages", new int[fl.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeFilms";
	}

@RequestMapping("/modifierFilm")
public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
{
Film f= filmService.getFilm(id);
modelMap.addAttribute("film", f);
modelMap.addAttribute("mode", "edit");
List<Genre> gs = filmService.getAllGenres();
modelMap.addAttribute("genres", gs);
return "formFilm";
}

@RequestMapping("/updateFilm")
public String updateFilm(@ModelAttribute("film") Film film,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException
{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateSortie = dateformat.parse(String.valueOf(date));
	 film.setDateSortie(dateSortie);

	 filmService.updateFilm(film);
	 List<Film> fi = filmService.getAllFilms();
	 modelMap.addAttribute("films", fi);
	return "listeFilms";
	}

///********************fonctions Genre**************

@Autowired
GenreService genreService;
@RequestMapping("/showCreateG")
public String showCreateG(ModelMap modelMap)
{
modelMap.addAttribute("genre", new Genre());
modelMap.addAttribute("mode", "new");
return "formGenre";
}
@RequestMapping("/saveGenre")
public String saveGenre(@Valid Genre genre, BindingResult bindingResult)
{
if (bindingResult.hasErrors()) return "formGenre";

genreService.saveGenre(genre);
return "redirect:/ListeGenres";
}
@RequestMapping("/supprimerGenre")
public String supprimerGenre(@RequestParam("id") Long id,

ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)

{
	genreService.deleteGenreById(id);
Page<Genre> g1 = genreService.getAllGenresParPage(page,size);

modelMap.addAttribute("genres", g1);
modelMap.addAttribute("pages", new int[g1.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeGenres";
}

@RequestMapping("/modifierGenre")
public String editerGenre(@RequestParam("id") Long id,ModelMap modelMap)
{
Genre g= genreService.getGenres(id);
modelMap.addAttribute("genre", g);
modelMap.addAttribute("mode", "edit");
return "formGenre";
}

@RequestMapping("/updateGenre")
public String updateGenre(@ModelAttribute("genre") Genre genre,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException
{

 genreService.updateGenres(genre);
 List<Genre> ge= genreService.getAllGenres();
 modelMap.addAttribute("genres", ge);
return "listeGenres";
}

@RequestMapping("/ListeGenres")
public String listeGenres(ModelMap modelMap,

@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)

{
Page<Genre> g = genreService.getAllGenresParPage(page, size);
modelMap.addAttribute("genres", g);

modelMap.addAttribute("pages", new int[g.getTotalPages()]);

modelMap.addAttribute("currentPage", page);
return "listeGenres";
}

@RequestMapping("/chercherNom")
public String chercherNom(@RequestParam("nomF") String nom,
		ModelMap modelMap)


{     
	  List <Film> f = filmService.findByNomFilmContains(nom);
	  
	  modelMap.addAttribute("films",f);

	  return "recherchenom";
} 


@RequestMapping("/chercherGenre")
public String chercherGenre(@ModelAttribute("nomF")Film formData,ModelMap modelMap, @RequestParam("g") Long g 
) {
	
	List<Genre> m = genreService.findAll();
	modelMap.addAttribute("genres", m);
	
	List<Film> f=filmService.findByGenreIdGenre(g);
	modelMap.addAttribute("films",f);

	return "rechercheGenre";
}


}
