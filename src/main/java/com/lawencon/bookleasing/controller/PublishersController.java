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
import com.lawencon.bookleasing.model.Publishers;
import com.lawencon.bookleasing.service.PublishersService;

/**
 * @author Imron Rosyadi
 */

@RestController
@RequestMapping("/publisher")
public class PublishersController {

	@Autowired
	private PublishersService publishersService;

	@GetMapping
	public Response<List<Publishers>> getAll() {
		try {
			List<Publishers> pub = publishersService.getListPublishers();
			return new Response<>(HttpStatus.OK, pub);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("/{code}")
	public Response<?> getByCode(@PathVariable("code") String code) {
		try {
			Publishers pub = publishersService.findByCode(code);
			return new Response<>(HttpStatus.OK, pub);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PostMapping
	public Response<?> addPublisher(@RequestBody String body) {
		try {
			Publishers pub = new ObjectMapper().readValue(body, Publishers.class);
			publishersService.insertPublisher(pub);
			return new Response<>(HttpStatus.CREATED, pub);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PutMapping
	public Response<?> updatePublisher(@RequestBody String body) {
		try {
			Publishers pub = new ObjectMapper().readValue(body, Publishers.class);
			publishersService.updatePublisher(pub);
			return new Response<>(HttpStatus.CREATED, pub);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@DeleteMapping("/{id}")
	public Response<?> deleteById(@PathVariable("id") Long id) {
		try {
			publishersService.deleteById(id);
			return new Response<>(HttpStatus.OK, null);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

}
