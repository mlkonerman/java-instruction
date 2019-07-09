package com.bmdb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bmdb.business.Movie;
import com.bmdb.db.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;

	@GetMapping("/")
	public JsonResponse getAll() {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(movieRepository.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@GetMapping("/{id}")
	public JsonResponse get(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			Optional<Movie> m = movieRepository.findById(id);
			if (m.isPresent())
				jr = JsonResponse.getInstance(m);
			else
				jr = JsonResponse.getInstance("No movie found for id " + id);
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@PostMapping("/")
	public JsonResponse add(@RequestBody Movie m) {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(movieRepository.save(m));
		} catch (Exception e) {
			e.printStackTrace();
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@PutMapping("/")
	public JsonResponse update(@RequestBody Movie m) {
		JsonResponse jr = null;
		try {
			if (movieRepository.existsById(m.getId())) {

				jr = JsonResponse.getInstance(movieRepository.save(m));
				jr = JsonResponse
						.getInstance("Movie id: " + m.getId() + " does not exist and you are attempting to save it.");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@DeleteMapping("/")
	public JsonResponse delete(@RequestBody Movie m) {
		JsonResponse jr = null;
		try {
			if (movieRepository.existsById(m.getId())) {
				movieRepository.delete(m);
				jr = JsonResponse.getInstance("Actor deleted.");
			} else {
				jr = JsonResponse
						.getInstance("Movie id: " + m.getId() + " does not exist and you are attempting to delete it.");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

}