package com.el.ally.wimp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.wimp.models.Actor;
import com.el.ally.wimp.models.Movie;
import com.el.ally.wimp.repositories.ActorRepository;
import com.el.ally.wimp.repositories.MovieRepository;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepository;
	
	private ActorRepository actorRepository;
	
	public MovieController() {	}
	
	@GetMapping("")
	public List<Movie> getAll() {
		return movieRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Movie getOne(@PathVariable long id) {
		return movieRepository.getOne(id);
	}
	
	@PostMapping("")
	public Movie create(@RequestBody Movie movie) {
		return movieRepository.save(movie);
	}
	
	@PostMapping("/{movieId}/actors")
	public Movie movieByActor(@PathVariable Long movieId, @RequestBody Long actorId) {
		Movie movie = movieRepository.findOne(movieId);
		Actor actor = actorRepository.findOne(actorId);
		movie.getAll().add(actor);
		movieRepository.save(movie);
		return movie;
	}
	
	@PutMapping("/{id}")
	public Movie update(@PathVariable long id, @RequestBody Movie movie) {
		movie.setId(id);

		return movieRepository.save(movie);
	}
	
	@DeleteMapping("/{id}")
	public Movie delete(@PathVariable long id) {
		Movie deletedMovie = movieRepository.findOne(id);
		movieRepository.delete(deletedMovie);
		return deletedMovie;
	}

}
