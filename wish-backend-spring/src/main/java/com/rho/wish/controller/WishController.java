package com.rho.wish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.rho.wish.model.Wish;
import com.rho.wish.service.WishService;

@CrossOrigin
@RestController // @Controller + @ResponseBody
@RequestMapping("/api/v1")
public class WishController {

	@Autowired
	WishService WishService;

	@GetMapping("/")
	public ResponseEntity<?> test() {
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}

	@GetMapping("/wish")
	public List<Wish> getWishList() {
		return WishService.sv_readWishList();
	}

	@GetMapping("/wish/{id}")
	public ResponseEntity<?> getWishById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(WishService.sv_readWishById(id), HttpStatus.OK);
	}

	@PostMapping("/wish")
	public ResponseEntity<?> postWish(@RequestBody Wish wish) throws IllegalAccessException {

		WishService.sv_createWish(wish);
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}

	@PutMapping("/wish/{id}")
	public ResponseEntity<?> putWishById(@PathVariable("id") Long id, @RequestBody Wish wish) {

		WishService.sv_updateWishById(id, wish);
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}

	@DeleteMapping("/wish/{id}")
	public ResponseEntity<?> deleteWishById(@PathVariable("id") Long id) {

		WishService.sv_deleteWishById(id);
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}
}
