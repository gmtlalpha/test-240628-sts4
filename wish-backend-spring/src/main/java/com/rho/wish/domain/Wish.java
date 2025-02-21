package com.rho.wish.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // 서버 실행시에 테이블이 h2에 생성됨 orm
public class Wish {
	@Id //PK를 해당변후로 하곘다
	@GeneratedValue(strategy = GenerationType.IDENTITY) //해당 데이터베이스 번호증가 전략을 따라감 
	private Long id;
	
	private String title;
	private String info;
	
}
