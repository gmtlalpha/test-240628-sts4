package com.rho.wish.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rho.wish.domain.Wish;
import com.rho.wish.repository.WishRepository;

import lombok.RequiredArgsConstructor;

// 기능을 정의할수있고 트랜잭션을 관리함

@RequiredArgsConstructor
@Service
public class WishService {
	
	
	// 함수는 송금()-> 레파지토리에 여러개의 함수를 실행 -> commit, rollback
	
	private final WishRepository wishRepository;
	
	@Transactional // 서비스 함수가 종료될때 coommmit할지 rollback할지 관리하곘다 //실패된 저장은 롤백시킴
	public Wish insertWish(Wish wish) {
		return wishRepository.save(wish);
	}
	
	@Transactional(readOnly = true) // JPA변경감지라는 내부기능 비활성화, select 할때 누가 update를 하면 처리과정에서 그걸또 읽어버려서 부정합이 되기때문에 막음
	public Wish getWishOne(Long id) {
//		return wishRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
//			@Override
//			public IllegalArgumentException get() {
//				return new IllegalArgumentException("id를 확인해주세요");
//			}
//		});
		//1.8 Lamda
		return wishRepository.findById(id)
				.orElseThrow(()->new IllegalArgumentException("id를 확인해주세요"));
		
	}
	
	@Transactional(readOnly = true)
	public List<Wish> getWishAll(){
		return wishRepository.findAll();
	}
	
	@Transactional
	public Wish updateWish(Long id, Wish wish) {
		Wish wishEntity = wishRepository.findById(id)
				.orElseThrow(()->new IllegalArgumentException("id를 확인해주세요")); // context 영속성컨테스트에 보관
		wishEntity.setTitle(wish.getTitle());
		wishEntity.setInfo(wish.getInfo());
		
		return wishEntity;
	}// 함수종료 -> 트랜잭션종료-> 영속화 되어있는 데이터를 DB로 갱신(flush) -> commit ->더티체킨
	
	@Transactional
	public String 삭제하기(Long id) {
		wishRepository.deleteById(id); //오류나면 자동 에러 보냄
		return "OK";
	}
}

