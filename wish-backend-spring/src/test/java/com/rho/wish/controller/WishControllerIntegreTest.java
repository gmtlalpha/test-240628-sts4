package com.rho.wish.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import com.rho.wish.model.Wish;
import com.rho.wish.service.WishService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

/**IT 
 * 모든 Bean을 IoC에 올리고 하는것
 *  WebEnvironment.MOCK)//실제톰켓이 아니라 다른톰켓으로 테스트  
 * WebEnvironment.RANDOM_PORT)//실제톰켓이
 */

//@Slf4j
@Transactional  // 각각테스트 함수가 종료될때 rollback해줌
@AutoConfigureMockMvc// MockMvc 를 IoC에등록해서 DI가 되게해줌 
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)//실제톰켓이 아니라 다른톰켓으로 테스트 
public class WishControllerIntegreTest {
	
	
	private static final Logger log = LoggerFactory.getLogger(WishControllerIntegreTest.class);
	
	@Autowired // DI
	private MockMvc mockMvc;
	
	@Autowired
	private WishService wishRepository;
	
	@Autowired
	private EntityManager entityManager; // DB관련
	
	@BeforeEach // 함수 각각 실해되기전에 할것 
	public void init() {
		entityManager.createNativeQuery("ALTER TABLE wish ALTER COLUMN id RESTART WITH 1").executeUpdate(); //h2
//		entityManager.createNativeQuery("ALTER TABLE wish AUTO_INCREMENT = 1").executeUpdate(); //mysql
		
	}
	
	@Test
	public void saveTest() throws Exception {
		Wish wish = new Wish(null,"title","name");
		String content = new ObjectMapper().writeValueAsString(wish);
//		log.info(content);
//		when(wishService.insertWish(wish)).thenReturn(new wish(1L,"title","name"));
		//-----------------------------------------------------------------------
		
		ResultActions resultAction = mockMvc.perform(post("/wish")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(content)
				.accept(MediaType.APPLICATION_JSON_UTF8));
		
		resultAction
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.title").value("title"))
		.andDo(MockMvcResultHandlers.print());
		
		
	}

	@Test
	public void findAllTest() throws Exception {
		List<Wish>wishs = new ArrayList<>();
		wishs.add(new Wish(1L,"title1","l"));
		wishs.add(new Wish(2L,"title2","2"));
//		when(wishService.getWishAll()).thenReturn(wishs);
		//---------------------------------------
		wishRepository.saveAll(wishs);
		
		ResultActions resultAction = mockMvc.perform(get("/wish")
				.accept(MediaType.APPLICATION_JSON_UTF8));
		
		resultAction
		.andExpect(status().isOk())
		.andExpect(jsonPath("$",Matchers.hasSize(2)))
		.andExpect(jsonPath("$.[0].title").value("title1"))
		.andDo(MockMvcResultHandlers.print());
	}
	@Test
	public void findByIdTest() throws Exception{
		List<Wish>wishs = new ArrayList<>();
		wishs.add(new Wish(1L,"title1","l"));
		wishs.add(new Wish(2L,"title2","2"));
		Long id = 1L;
		wishRepository.saveAll(wishs);
		//-------------------------------------------------------------------------
		
		
		ResultActions resultAction = mockMvc.perform(get("/wish/{id}",id)
				.accept(MediaType.APPLICATION_JSON_UTF8));
		
		resultAction
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.title").value("title"))
		.andDo(MockMvcResultHandlers.print());
		
	}
	
	@Test
	public void updateTest() throws Exception{
		
		List<Wish>wishs = new ArrayList<>();
		wishs.add(new Wish(1L,"title1","l"));
		wishs.add(new Wish(2L,"title2","2"));
		Long id = 1L;
		wishRepository.saveAll(wishs);
		
		Wish wish = new Wish(null,"title3","3");
		String content = new ObjectMapper().writeValueAsString(wish);
		
		ResultActions resultAction = mockMvc.perform(put("/wish/{id}",id)
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(content)
				.accept(MediaType.APPLICATION_JSON_UTF8));
		
		resultAction
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.title").value("title"))
		.andDo(MockMvcResultHandlers.print());
		
	}
	
}
