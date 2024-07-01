package com.rho.wish.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rho.wish.domain.Wish;
import com.rho.wish.service.WishService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final 걸면 자동으로 만들어줌
@RestController
@CrossOrigin
public class WishController {

	private final WishService wishService;
	
	@GetMapping("/")
	public ResponseEntity<?> test() {
		
		return new ResponseEntity<String>("ok2", HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/wish")
	public ResponseEntity<?> findAll() {
		
		return new ResponseEntity<>(wishService.getWishAll(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/wish")
	public ResponseEntity<?> save(@RequestBody Wish wish) throws IllegalAccessException{
		
//		throw new IllegalAccessException("IT IS NOT RIGHT");
		return new ResponseEntity<>(wishService.insertWish(wish), HttpStatus.CREATED);
	}
	
	@GetMapping("/wish/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		
		return new ResponseEntity<>(wishService.getWishOne(id), HttpStatus.OK);
	}
	
	@PutMapping("/wish/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Wish wish) {
		
		return new ResponseEntity<>(wishService.updateWish(id, wish), HttpStatus.OK);
	}
	
	@DeleteMapping("/wish/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		
		return new ResponseEntity<>(wishService.삭제하기(id), HttpStatus.OK);
	}
}
