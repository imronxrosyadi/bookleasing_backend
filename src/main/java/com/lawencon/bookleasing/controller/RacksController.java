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
import com.lawencon.bookleasing.model.Racks;
import com.lawencon.bookleasing.service.RacksService;

/**
 * @author Imron Rosyadi
 */

@RestController
@RequestMapping("/rack")
public class RacksController {

	@Autowired
	private RacksService racksService;

	@GetMapping
	public Response<List<Racks>> getAll() {
		try {
			List<Racks> rack = racksService.getListRacks();
			return new Response<>(HttpStatus.OK, rack);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("/{code}")
	public Response<?> getByCode(@PathVariable("code") String code) {
		try {
			Racks rack = racksService.findByCode(code);
			return new Response<>(HttpStatus.OK, rack);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PostMapping
	public Response<?> addRack(@RequestBody String body) {
		try {
			Racks rack = new ObjectMapper().readValue(body, Racks.class);
			racksService.insertRack(rack);
			return new Response<>(HttpStatus.CREATED, rack);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PutMapping
	public Response<?> updateRack(@RequestBody String body) {
		try {
			Racks rack = new ObjectMapper().readValue(body, Racks.class);
			racksService.updateRack(rack);
			return new Response<>(HttpStatus.CREATED, rack);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@DeleteMapping("/{id}")
	public Response<?> deleteById(@PathVariable("id") Long id) {
		try {
			racksService.deleteById(id);
			return new Response<>(HttpStatus.OK, null);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

}
