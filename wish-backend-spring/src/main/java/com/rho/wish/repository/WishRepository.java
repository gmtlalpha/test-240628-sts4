package com.rho.wish.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rho.wish.domain.Wish;


// @Repository 적어야 스프링 IoC에 빈으로 등록이 되는데
// JpaRepository를 extends하면 생략가능함. 빈으로 자동 등록됨
// JpaRepository는 CRUD함수를가지고있음
public interface WishRepository extends JpaRepository<Wish, Long> {

}
