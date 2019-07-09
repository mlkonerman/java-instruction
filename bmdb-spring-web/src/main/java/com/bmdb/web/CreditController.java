package com.bmdb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bmdb.business.Credit;
import com.bmdb.db.CreditRepository;

@RestController
@RequestMapping("/credits")
public class CreditController {

	@Autowired
	private CreditRepository creditRepository;

	@GetMapping("/")
	public JsonResponse getAll() {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(creditRepository.findAll());
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
			Optional<Credit> c = creditRepository.findById(id);
			if (c.isPresent())
				jr = JsonResponse.getInstance(c);
			else
				jr = JsonResponse.getInstance("No credit found for id " + id);
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@GetMapping("")
	public JsonResponse getByRole(@RequestParam String role) {
		JsonResponse jr = null;
		try {
			Optional<Credit> c = creditRepository.findByRole(role);
			if (c.isPresent())
				jr = JsonResponse.getInstance(c);
			else
				jr = JsonResponse.getInstance("No credit found for role " + role);
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@PostMapping("/")
	public JsonResponse add(@RequestBody Credit c) {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(creditRepository.save(c));
		} catch (Exception e) {
			e.printStackTrace();
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@PutMapping("/")
	public JsonResponse update(@RequestBody Credit c) {
		JsonResponse jr = null;
		try {
			if (creditRepository.existsById(c.getId())) {
				jr = JsonResponse.getInstance(creditRepository.save(c));
			} else {
				jr = JsonResponse.getInstance(
						"Credit id: " + c.getId() + " does not exist and you are attempting to save it.");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@DeleteMapping("/")
	public JsonResponse delete(@RequestBody Credit c) {
		JsonResponse jr = null;
		try {
			if (creditRepository.existsById(c.getId())) {
				creditRepository.delete(c);
				jr = JsonResponse.getInstance("Credit deleted.");
			} else {
				jr = JsonResponse.getInstance(
						"Credit id: " + c.getId() + " does not exist and you are attempting to delete it.");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

}