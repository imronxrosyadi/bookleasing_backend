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
import com.lawencon.bookleasing.model.Books;
import com.lawencon.bookleasing.service.BooksService;

/**
 * @author Imron Rosyadi
 */

@RestController
@RequestMapping("/book")
public class BooksController {

	@Autowired
	private BooksService booksService;

	@GetMapping
	public Response<List<Books>> getAll() {
		try {
			List<Books> bk = booksService.getListBooks();
			return new Response<>(HttpStatus.OK, bk);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("/{code}")
	public Response<?> getByCode(@PathVariable("code") String code) {
		try {
			Books bk = booksService.findByCode(code);
			return new Response<>(HttpStatus.OK, bk);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PostMapping
	public Response<?> addBook(@RequestBody String body) {
		try {
			Books bk = new ObjectMapper().readValue(body, Books.class);
			booksService.insertBook(bk);
			return new Response<>(HttpStatus.CREATED, bk);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PutMapping
	public Response<?> updateBook(@RequestBody String body) {
		try {
			Books book = new ObjectMapper().readValue(body, Books.class);
			booksService.updateBook(book);
			return new Response<>(HttpStatus.CREATED, book);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@DeleteMapping("/{id}")
	public Response<?> deleteById(@PathVariable("id") Long id) {
		try {
			booksService.deleteById(id);
			return new Response<>(HttpStatus.OK, null);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}
}
