package com.lawencon.bookleasing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.bookleasing.helper.Response;
import com.lawencon.bookleasing.model.Users;
import com.lawencon.bookleasing.service.UsersService;

/**
 * @author Imron Rosyadi
 */
@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@GetMapping
	public Response<List<Users>> getAll() {
		try {
			List<Users> usr = usersService.getListUsers();
			return new Response<>(HttpStatus.OK, usr);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("/{uname}")
	public Response<?> getByCode(@PathVariable("uname") String uname) {
		try {
			Users usr = usersService.findByCode(uname);
			return new Response<>(HttpStatus.OK, usr);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PostMapping
	public Response<?> addUser(@RequestBody String body) {
		try {
			Users usr = new ObjectMapper().readValue(body, Users.class);
			usersService.insertUsers(usr);
			return new Response<>(HttpStatus.CREATED, usr);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@DeleteMapping("/{id}")
	public Response<?> deleteUserById(@PathVariable Long id) {
		try {
			usersService.deleteById(id);
			return new Response<>(HttpStatus.OK, null);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PatchMapping
	public Response<?> updateUser(@RequestBody String body) {
		try {
			Users usr = new ObjectMapper().readValue(body, Users.class);
			usersService.updateUser(usr);
			return new Response<>(HttpStatus.CREATED, usr);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}
}
