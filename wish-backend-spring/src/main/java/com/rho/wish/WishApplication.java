package com.rho.wish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WishApplication {
	
	enum Season {
	    SPRING("봄"),
	    SUMMER("여름"),
	    FALL("가을"),
	    WINTER("겨울");
		
	    // 문자열을 저장할 필드
	    private String season;

		// 생성자 (싱글톤)
	    private Season(String season) {
	        this.season = season;
	    }

		// Getter
	    public String getSeason() {
	        return season;
	    }
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WishApplication.class, args);
	}

}
