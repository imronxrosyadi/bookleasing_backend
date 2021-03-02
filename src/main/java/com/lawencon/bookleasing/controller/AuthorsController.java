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
import com.lawencon.bookleasing.model.Authors;
import com.lawencon.bookleasing.service.AuthorsService;

/**
 * @author Imron Rosyadi
 */

@RestController
@RequestMapping("/author")
public class AuthorsController {

	@Autowired
	private AuthorsService authorsService;

	@GetMapping
	public Response<List<Authors>> getAll() {
		try {
			List<Authors> aut = authorsService.getListAuthors();
			return new Response<>(HttpStatus.OK, aut);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("/{code}")
	public Response<?> getByCode(@PathVariable("code") String code) {
		try {
			Authors aut = authorsService.findByCode(code);
			return new Response<>(HttpStatus.OK, aut);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PostMapping
	public Response<?> addAuthor(@RequestBody String body) {
		try {
			Authors aut = new ObjectMapper().readValue(body, Authors.class);
			authorsService.insertAuthor(aut);
			return new Response<>(HttpStatus.CREATED, aut);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PutMapping
	public Response<?> updateAuthor(@RequestBody String body) {
		try {
			Authors aut = new ObjectMapper().readValue(body, Authors.class);
			authorsService.updateAuthor(aut);
			return new Response<>(HttpStatus.CREATED, aut);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@DeleteMapping("/{id}")
	public Response<?> deleteById(@PathVariable("id") Long id) {
		try {
			authorsService.deleteById(id);
			return new Response<>(HttpStatus.OK, null);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

}
