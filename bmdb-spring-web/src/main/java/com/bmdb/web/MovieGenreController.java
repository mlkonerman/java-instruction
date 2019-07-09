package com.bmdb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bmdb.business.MovieGenre;
import com.bmdb.db.MovieGenreRepository;

@RestController
@RequestMapping("/movie-genres")
public class MovieGenreController {

	@Autowired
	private MovieGenreRepository mgRepository;

	@GetMapping("/")
	public JsonResponse getAll() {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(mgRepository.findAll());
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
			Optional<MovieGenre> mg = mgRepository.findById(id);
			if (mg.isPresent())
				jr = JsonResponse.getInstance(mg);
			else
				jr = JsonResponse.getInstance("No genre designation found for id " + id);
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@PostMapping("/")
	public JsonResponse add(@RequestBody MovieGenre mg) {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(mgRepository.save(mg));
		} catch (Exception e) {
			e.printStackTrace();
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@PutMapping("/")
	public JsonResponse update(@RequestBody MovieGenre mg) {
		JsonResponse jr = null;
		try {
			if (mgRepository.existsById(mg.getId())) {

				jr = JsonResponse.getInstance(mgRepository.save(mg));
			} else {
				jr = JsonResponse.getInstance(
						"Genre designation id: " + mg.getId() + " does not exist and you are attempting to save it.");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@DeleteMapping("/")
	public JsonResponse delete(@RequestBody MovieGenre mg) {
		JsonResponse jr = null;
		try {
			if (mgRepository.existsById(mg.getId())) {
				mgRepository.delete(mg);
				jr = JsonResponse.getInstance("Genre designation deleted.");
			} else {
				jr = JsonResponse.getInstance(
						"Genre designation id: " + mg.getId() + " does not exist and you are attempting to delete it.");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
}
