package com.bmdb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bmdb.business.Genre;
import com.bmdb.db.GenreRepository;

@RestController
@RequestMapping("/genres")
public class GenreController {

	@Autowired
	private GenreRepository genreRepository;

	@GetMapping("/")
	public JsonResponse getAll() {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(genreRepository.findAll());
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
			Optional<Genre> g = genreRepository.findById(id);
			if (g.isPresent())
				jr = JsonResponse.getInstance(g);
			else
				jr = JsonResponse.getInstance("No genre found for id " + id);
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@PostMapping("/")
	public JsonResponse add(@RequestBody Genre g) {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(genreRepository.save(g));
		} catch (Exception e) {
			e.printStackTrace();
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@PutMapping("/")
	public JsonResponse update(@RequestBody Genre g) {
		JsonResponse jr = null;
		try {
			if (genreRepository.existsById(g.getId())) {

				jr = JsonResponse.getInstance(genreRepository.save(g));
			} else {
				jr = JsonResponse
						.getInstance("Genre id: " + g.getId() + " does not exist and you are attempting to save it.");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@DeleteMapping("/")
	public JsonResponse delete(@RequestBody Genre g) {
		JsonResponse jr = null;
		try {
			if (genreRepository.existsById(g.getId())) {
				genreRepository.delete(g);
				jr = JsonResponse.getInstance("Genre deleted.");
			} else {
				jr = JsonResponse
						.getInstance("Genre id: " + g.getId() + " does not exist and you are attempting to delete it.");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

}
