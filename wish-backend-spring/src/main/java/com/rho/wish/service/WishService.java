package com.rho.wish.service;

import java.util.List;

import com.rho.wish.model.Wish;


public interface WishService{
	
	void sv_createWish(Wish wish);

	List<Wish> sv_readWishList();
	
	Wish sv_readWishById(Long id);
	
	void sv_updateWishById(Long id, Wish wish);
	
	void sv_deleteWishById(Long id);
	
}
