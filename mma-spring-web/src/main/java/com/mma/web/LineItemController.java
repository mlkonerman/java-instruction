package com.mma.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mma.business.LineItem;
import com.mma.business.Product;
import com.mma.db.LineItemRepository;

@RestController
@RequestMapping("/line-items")
public class LineItemController {

	@Autowired
	private LineItemRepository lineItemRepository;

	@GetMapping("/")
	public JsonResponse getAll() {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(lineItemRepository.findAll());
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@GetMapping("/{id}")
	public JsonResponse get(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			Optional<LineItem> li = lineItemRepository.findById(id);
			if (li.isPresent())
				jr = JsonResponse.getInstance(li);
			else
				jr = JsonResponse.getInstance("No line item found for id " + id);
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@PostMapping("/")
	public JsonResponse add(@RequestBody LineItem li) {
		JsonResponse jr = null;
		// NOTE: May need to enhance exception handling if more than one exception type
		// needs to be caught
		try {
			jr = JsonResponse.getInstance(lineItemRepository.save(li));
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@PutMapping("/")
	public JsonResponse update(@RequestBody LineItem li) {
		JsonResponse jr = null;
		// NOTE: May need to enhance exception handling if more than one exception type
		// needs to be caught
		try {
			if (lineItemRepository.existsById(li.getId())) {

				jr = JsonResponse.getInstance(lineItemRepository.save(li));
			} else {
				jr = JsonResponse.getInstance(
						"Line Item id: " + li.getId() + " does not exist and" + "you are attempting to save it.");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}

	@DeleteMapping("/")
	public JsonResponse delete(@RequestBody LineItem li) {
		JsonResponse jr = null;
		// NOTE: May need to enhance exception handling if more than one exception type
		// needs to be caught
		try {
			if (lineItemRepository.existsById(li.getId())) {
				lineItemRepository.delete(li);
				jr = JsonResponse.getInstance("Line item deleted.");
			} else {
				jr = JsonResponse.getInstance(
						"Line item id: " + li.getId() + " does not exist and" + "you are attempting to delete it.");
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
}
