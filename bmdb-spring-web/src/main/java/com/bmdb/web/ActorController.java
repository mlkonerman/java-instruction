package com.bmdb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmdb.business.Actor;
import com.bmdb.db.ActorRepository;

@RestController
@RequestMapping("/actors")
public class ActorController {

	@Autowired
	private ActorRepository actorRepository;

	@GetMapping("/")
	public JsonResponse getAll() {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(actorRepository.findAll());
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
			Optional<Actor> a = actorRepository.findById(id);
			if (a.isPresent())
				jr = JsonResponse.getInstance(a);
			else
				jr = JsonResponse.getInstance("No actor found for id " + id);
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@PostMapping("/")
	public JsonResponse add(@RequestBody Actor a) {
		JsonResponse jr = null;
		// NOTE: May need to enhance exception handling if more than one exception type
		// needs to be caught
		try {
			jr = JsonResponse.getInstance(actorRepository.save(a));
		} catch (Exception e) {
			e.printStackTrace();
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@PutMapping("/")
	public JsonResponse update(@RequestBody Actor a) {
		JsonResponse jr = null;
		// NOTE: May need to enhance exception handling if more than one exception type
		// needs to be caught
		try {
			if (actorRepository.existsById(a.getId())) {

				jr = JsonResponse.getInstance(actorRepository.save(a));
			} else {
				jr = JsonResponse.getInstance(
						"Actor id: " + a.getId() + " does not exist and" + "you are attempting to save it.");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@DeleteMapping("/")
	public JsonResponse delete(@RequestBody Actor a) {
		JsonResponse jr = null;
		// NOTE: May need to enhance exception handling if more than one exception type
		// needs to be caught
		try {
			if (actorRepository.existsById(a.getId())) {
				actorRepository.delete(a);
				jr = JsonResponse.getInstance("Actor deleted.");
			} else {
				jr = JsonResponse.getInstance(
						"Actor id: " + a.getId() + " does not exist and you are attempting to delete it.");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

}
