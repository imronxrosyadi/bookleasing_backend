package com.lawencon.bookleasing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.bookleasing.helper.Response;
import com.lawencon.bookleasing.model.Categories;
import com.lawencon.bookleasing.service.CategoriesService;

/**
 * @author Imron Rosyadi
 */

@RestController
@RequestMapping("/category")
public class CategoriesController {

	@Autowired
	private CategoriesService categoriesService;

	@GetMapping
	public Response<List<Categories>> getAll() {
		try {
			List<Categories> cat = categoriesService.getListCategories();
			return new Response<>(HttpStatus.OK, cat);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("/{code}")
	public Response<?> getByCode(@PathVariable("code") String code) {
		try {
			Categories cat = categoriesService.findByCode(code);
			return new Response<>(HttpStatus.OK, cat);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PostMapping
	public Response<?> addCategory(@RequestBody String body) {
		try {
			Categories cat = new ObjectMapper().readValue(body, Categories.class);
			categoriesService.insertCategorie(cat);
			return new Response<>(HttpStatus.CREATED, cat);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PutMapping
	public Response<?> updateCategory(@RequestBody String body) {
		try {
			Categories cat = new ObjectMapper().readValue(body, Categories.class);
			categoriesService.updateCategory(cat);
			return new Response<>(HttpStatus.CREATED, cat);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@DeleteMapping("/{id}")
	public Response<?> deleteById(@PathVariable("id") Long id) {
		try {
			categoriesService.deleteById(id);
			return new Response<>(HttpStatus.OK, null);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

}
