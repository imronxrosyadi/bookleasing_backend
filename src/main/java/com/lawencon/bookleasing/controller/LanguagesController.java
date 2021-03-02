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
import com.lawencon.bookleasing.model.Languages;
import com.lawencon.bookleasing.service.LanguagesService;

/**
 * @author Imron Rosyadi
 */

@RestController
@RequestMapping("/language")
public class LanguagesController {

	@Autowired
	private LanguagesService languagesService;

	@GetMapping
	public Response<List<Languages>> getAll() {
		try {
			List<Languages> lang = languagesService.getListLanguages();
			return new Response<>(HttpStatus.OK, lang);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("/{code}")
	public Response<?> getByCode(@PathVariable("code") String code) {
		try {
			Languages lang = languagesService.findByCode(code);
			return new Response<>(HttpStatus.OK, lang);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PostMapping
	public Response<?> addLanguage(@RequestBody String body) {
		try {
			Languages lang = new ObjectMapper().readValue(body, Languages.class);
			languagesService.insertLanguage(lang);
			return new Response<>(HttpStatus.CREATED, lang);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PutMapping
	public Response<?> updateLanguage(@RequestBody String body) {
		try {
			Languages lang = new ObjectMapper().readValue(body, Languages.class);
			languagesService.updateLanguage(lang);
			return new Response<>(HttpStatus.CREATED, lang);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@DeleteMapping("/{id}")
	public Response<?> deleteById(@PathVariable("id") Long id) {
		try {
			languagesService.deleteById(id);
			return new Response<>(HttpStatus.OK, null);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

}
