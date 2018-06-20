package com.el.ally.wimp.configuration;

import java.util.Date;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.el.ally.wimp.models.Actor;
import com.el.ally.wimp.models.Movie;
import com.el.ally.wimp.repositories.ActorRepository;
import com.el.ally.wimp.repositories.MovieRepository;



@Configuration
@Profile("development")

public class SeedData {



	public SeedData(ActorRepository actorRepository, MovieRepository movieRepository) {
		actorRepository.save(new Actor("firstname", "secondname", 1234, new Date()));
		movieRepository.save(new Movie("title", "2018", 12345, "distributor"));
	}

	

}