package com.rho.wish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rho.wish.controller.WishController;
import com.rho.wish.model.Wish;
import com.rho.wish.model.WishMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WishServiceImpl implements WishService {

	@Autowired
	private WishMapper WishMapper;

	@Transactional
	@Override
	public void sv_createWish(Wish wish) {
		WishMapper.createWish(wish);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Wish> sv_readWishList() {
		List<Wish> wishlist = WishMapper.readWishList();
		wishlist.forEach((wish) -> log.info(wish.toString()));

		for (Wish i : wishlist) {
			log.info(i.toString());
		}
		return wishlist;
	}

	@Transactional(readOnly = true)
	@Override
	public Wish sv_readWishById(Long id) {
		return WishMapper.readWishById(id);
	}

	@Transactional
	@Override
	public void sv_updateWishById(Long id, Wish wish) {
		WishMapper.updateWishById(id, wish);
	}

	@Transactional
	@Override
	public void sv_deleteWishById(Long id) {
		WishMapper.deleteWishById(id);
	}

}
