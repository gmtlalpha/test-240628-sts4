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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rho.wish.domain.Wish;
import com.rho.wish.service.WishService;

import lombok.extern.slf4j.Slf4j;

//@RequestMapping: 요청을 처리할 메서드를 지정하는 어노테이션입니다. 이 어노테이션은 HTTP 메서드와 URL을 매핑합니다.
//@RequestMapping("/api/users")
//@RestController: 컨트롤러 클래스를 나타내는 어노테이션입니다. 
//이 어노테이션은 @Controller와 @ResponseBody를 합친 것으로, 반환값이 자동으로 JSON 형태로 변환됩니다.
@CrossOrigin
@RestController
@Slf4j
public class WishController {

	@Autowired
	WishService WishService;
	
	
	@GetMapping("/")
	public ResponseEntity<?> test() {
		log.info("Get /");
		return new ResponseEntity<String>("Get / ok", HttpStatus.OK);
	}
	
	@GetMapping("/wish")
	public List<Wish>readWishAll() {
//	public ResponseEntity<?> readWishAll() {
		log.info("Get /wish");
//		return new ResponseEntity<>(WishService.readWishAll(), HttpStatus.OK);
		return WishService.readWishAll();
	}
	
	@GetMapping("/wish/{id}")
	public ResponseEntity<?> readWishOne(@PathVariable("id") Long id) {
		
		log.info("Get /wish/{id}");
		return new ResponseEntity<>(WishService.readWishOne(id), HttpStatus.OK);
	}
	
	@PostMapping("/wish")
	public ResponseEntity<?> createWish(@RequestBody Wish wish) throws IllegalAccessException{
		
		WishService.createWish(wish);
		return new ResponseEntity<String>("Post /wish ok", HttpStatus.OK);
	}
	
	@PutMapping("/wish/{id}")
	public ResponseEntity<?> updateWish(@PathVariable("id") Long id, @RequestBody Wish wish) {
		
		WishService.updateWish(id, wish);
		return new ResponseEntity<String>("Put /wish/{id} ok", HttpStatus.OK);
	}
	
	@DeleteMapping("/wish/{id}")
	public ResponseEntity<?> deleteWishOne(@PathVariable("id") Long id) {
		
		WishService.deleteWishOne(id);
		return new ResponseEntity<String>("Delete /wish/{id} ok", HttpStatus.OK);
	}
}
