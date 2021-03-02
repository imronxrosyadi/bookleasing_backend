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
import com.lawencon.bookleasing.model.BookDetails;
import com.lawencon.bookleasing.service.BookDetailsService;

/**
 * @author Imron Rosyadi
 */

@RestController
@RequestMapping("/bookdetail")
public class BookDetailsController {

	@Autowired
	private BookDetailsService bookDetailsService;

	@GetMapping
	public Response<List<BookDetails>> getAll() {
		try {
			List<BookDetails> bd = bookDetailsService.getListBookDetails();
			return new Response<>(HttpStatus.OK, bd);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("/{code}")
	public Response<?> getByCode(@PathVariable("code") String code) {
		try {
			BookDetails bd = bookDetailsService.findByCode(code);
			return new Response<>(HttpStatus.OK, bd);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("bookcode/{code}")
	public Response<?> getByBookCode(@PathVariable("code") String code) {
		try {
			List<BookDetails> bd = bookDetailsService.findByBookCode(code);
			return new Response<>(HttpStatus.OK, bd);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PostMapping
	public Response<?> addBookDetail(@RequestBody String body) {
		try {
			BookDetails bd = new ObjectMapper().readValue(body, BookDetails.class);
			bookDetailsService.insertBookDetails(bd);
			return new Response<>(HttpStatus.CREATED, bd);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PutMapping
	public Response<?> updateAuthor(@RequestBody String body) {
		try {
			BookDetails bookDtl = new ObjectMapper().readValue(body, BookDetails.class);
			bookDetailsService.updateBookDetail(bookDtl);
			return new Response<>(HttpStatus.CREATED, bookDtl);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@DeleteMapping("/{id}")
	public Response<?> deleteById(@PathVariable("id") Long id) {
		try {
			bookDetailsService.deleteById(id);
			return new Response<>(HttpStatus.OK, null);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

}
