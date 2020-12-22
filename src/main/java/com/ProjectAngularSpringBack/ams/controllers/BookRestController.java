package com.ProjectAngularSpringBack.ams.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjectAngularSpringBack.ams.entities.Book;
import com.ProjectAngularSpringBack.ams.entities.Provider;
import com.ProjectAngularSpringBack.ams.exceptions.ResourceNotFoundException;
import com.ProjectAngularSpringBack.ams.repositories.BookRepository;



@RestController
@RequestMapping({ "/books" })
@CrossOrigin(origins ="*")
public class BookRestController {
	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/list")
	public List<Book> getAllBook() {
		return (List<Book>) bookRepository.findAll();
	}

	
	@PostMapping("/add")
	public Book createBook(@Valid @RequestBody Book book) {
		return bookRepository.save(book);
	}

	@PutMapping("/{bookId}")
	public Book updateBook(@PathVariable Long bookId, @Valid @RequestBody Book bookRequest) {
		return bookRepository.findById(bookId).map(book -> {
			book.setTitle(bookRequest.getTitle());
			book.setAuthor(bookRequest.getAuthor());
			book.setPrice(bookRequest.getPrice());
			book.setQuantity(bookRequest.getQuantity());
			book.setReleaseDate(bookRequest.getReleaseDate());
		
			return bookRepository.save(book);
		}).orElseThrow(() -> new ResourceNotFoundException("Book Id " + bookId + " not found"));
	}

	
	
	@DeleteMapping("/{bookId}") 
	public ResponseEntity<?> deleteBook(@PathVariable Long bookId) {
		return bookRepository.findById(bookId).map(book -> {
			bookRepository.delete(book);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Book Id " + bookId + " not found"));
	}

	
	@GetMapping("/{bookId}")
	 public Optional<Book> getBook(@PathVariable Long bookId)
	{
	     return  bookRepository.findById(bookId);
	 }
	
	/*@DeleteMapping("/{providerId}")
	public Provider deleteProvider(@PathVariable Long providerId) {
		Provider provider = providerRepository.findById(providerId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid provider Id:" + providerId));
		providerRepository.delete(provider);
		return provider;
	}*/
}
