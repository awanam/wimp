package com.el.ally.wimp.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.wimp.models.Actor;
import com.el.ally.wimp.repositories.ActorRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/actor")
public class ActorController {
	
	@Autowired
	private ActorRepository actorRepository;
	
	@GetMapping("")
	public List<Actor> getAll() {
		return actorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Actor getOne(@PathVariable long id) {
		return actorRepository.getOne(id);
	}
	
	@PostMapping("")
	public Actor create(@RequestBody Actor actor) {
		return actorRepository.save(actor);
	}
	
	@PutMapping("/{id}")
	public Actor update(@PathVariable long id, @RequestBody Actor actor) {
		actor.setId(id);

		return actorRepository.save(actor);
	}
	
	@DeleteMapping("/{id}")
	public Actor delete(@PathVariable long id) {
		Actor deletedActor = actorRepository.findOne(id);
		actorRepository.delete(deletedActor);
		return deletedActor;
	}

}
