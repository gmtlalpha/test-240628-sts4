/**
 * 
 */
package com.rho.wish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rho.wish.domain.Wish;
import com.rho.wish.domain.WishMapper;

/**기능을 정의할수있고 트랜잭션을 관리함
 * 
 */
@Service
public class WishServiceImpl implements WishService {
	
	// 함수는 송금()-> 레파지토리에 여러개의 함수를 실행 -> commit, rollback
	@Autowired//@Autowired: 의존성 주입을 위한 어노테이션입니다. 스프링이 자동으로 해당 타입의 빈을 찾아 주입해 줍
	private WishMapper WishMapper;
	
	@Transactional(readOnly = true)
	@Override
	public List<Wish> readWishAll() {
		return WishMapper.readWishAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Wish readWishOne(Long id) {
		return WishMapper.readWishOne(id);
	}

	// 서비스 함수가 종료될때 coommmit할지 rollback할지 관리하곘다 
	//실패된 저장은 롤백시킴
	@Transactional 
	@Override
	public void createWish(Wish wish) {
		WishMapper.createWish(wish);
	}

	// 함수종료 -> 트랜잭션종료-> 영속화 되어있는 데이터를 DB로 갱신(flush) -> commit ->더티체킨
	@Transactional
	@Override
	public void updateWish(Long id, Wish wish) {
		Wish mdlWish = readWishOne(id);
		WishMapper.updateWish(id, mdlWish);
	}

	@Transactional
	@Override
	public void deleteWishOne(Long id) {
		WishMapper.deleteWishOne(id); //오류나면 자동 에러 보냄
	}

}
