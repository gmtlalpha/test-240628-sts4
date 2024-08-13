package com.rho.wish.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WishMapper {

	void createWish(Wish wish);
	
	List<Wish> readWishList();
	
	Wish readWishById(Long id);
	
	void updateWishById(@Param("pId") Long id,Wish wish);
	
	void deleteWishById(Long id);
	
}
