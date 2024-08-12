package com.rho.wish.service;

import java.util.List;

import com.rho.wish.domain.Wish;


public interface WishService{ // entity DAO //data Access Object
	
	List<Wish> readWishAll();
	
	Wish readWishOne(Long id);
	
	void createWish(Wish wish);
	
	void updateWish(Long id, Wish wish);
	
	void deleteWishOne(Long id);
	
}
