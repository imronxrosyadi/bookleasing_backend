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
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.bookleasing.helper.Response;
import com.lawencon.bookleasing.model.Profiles;
import com.lawencon.bookleasing.service.ProfilesService;

/**
 * @author Imron Rosyadi
 */

@RestController
public class ProfilesController {

	@Autowired
	private ProfilesService profilesService;

	@GetMapping("/profile")
	public Response<List<Profiles>> getAll() {
		try {
			List<Profiles> pfl = profilesService.getListProfiles();
			return new Response<>(HttpStatus.OK, pfl);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("/profile/{code}")
	public Response<?> getByCode(@PathVariable("code") String code) {
		try {
			Profiles pfl = profilesService.findByCode(code);
			return new Response<>(HttpStatus.OK, pfl);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("/profile/user/{userId}")
	public Response<?> getByUserId(@PathVariable("userId") Long userId) {
		try {
			Profiles pfl = profilesService.findByUserId(userId);
			return new Response<>(HttpStatus.OK, pfl);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PostMapping("/profile")
	public Response<?> addProfile(@RequestBody String body) {
		try {
			Profiles pfl = new ObjectMapper().readValue(body, Profiles.class);
			profilesService.insertProfile(pfl);
			return new Response<>(HttpStatus.CREATED, pfl);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PostMapping("/login")
	public Response<?> loginProfile(@RequestBody String body) {
		try {
			Profiles pfl = new ObjectMapper().readValue(body, Profiles.class);
			pfl = profilesService.loginProfile(pfl);
			return new Response<>(HttpStatus.CREATED, pfl);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PutMapping
	public Response<?> updateProfile(@RequestBody String body) {
		try {
			Profiles pro = new ObjectMapper().readValue(body, Profiles.class);
			profilesService.updateProfile(pro);
			return new Response<>(HttpStatus.CREATED, pro);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@DeleteMapping("/{id}")
	public Response<?> deleteById(@PathVariable("id") Long id) {
		try {
			profilesService.deleteById(id);
			return new Response<>(HttpStatus.OK, null);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

}
