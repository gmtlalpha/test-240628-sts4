package com.rho.wish.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rho.wish.model.Wish;
import com.rho.wish.service.WishServiceImpl2;

import lombok.extern.slf4j.Slf4j;

//UT // 컨트롤러 관련 로직만 띄우기 // Controller, Filter, ControllerAdvice

@Slf4j
@WebMvcTest //@ExtendWith(SpringExtension.class) Junit 5
public class WishControllerUnitTest { 
	

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean // IoC환경에 bean등록됨
	private WishServiceImpl2 wishService;
	
	@SuppressWarnings("deprecation")
	@Test
	public void saveTest() throws Exception {
		Wish wish = new Wish(null,"title","name");
		String content = new ObjectMapper().writeValueAsString(wish);
		log.info(content);
		when(wishService.insertWish(wish)).thenReturn(new Wish(1L,"title","name"));
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
		when(wishService.getWishAll()).thenReturn(wishs);
		//---------------------------------------
		
		
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
		Long id = 1L;
		when(wishService.getWishOne(id)).thenReturn(new Wish(id,"title","1"));
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
		
		Long id = 1L;
		Wish wish = new Wish(null,"title","name");
		String content = new ObjectMapper().writeValueAsString(wish);
		when(wishService.updateWish(id, wish)).thenReturn(new Wish(1L,"title","name"));
		//-------------------------------------------------------------------------
		
		
		
		ResultActions resultAction = mockMvc.perform(put("/wish/{id}",id)
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(content)
				.accept(MediaType.APPLICATION_JSON_UTF8));
		
		resultAction
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.title").value("title"))
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void deleteTest() throws Exception{
		
		Long id = 1L;
		when(wishService.삭제하기(id)).thenReturn("ok");
		//-------------------------------------------------------------------------
		
		ResultActions resultAction = mockMvc.perform(delete("/wish/{id}",id)
				.accept(MediaType.TEXT_PLAIN));
		
		resultAction
		.andExpect(status().isOk())
		.andDo(MockMvcResultHandlers.print());
		
		MvcResult requestResult = resultAction.andReturn();
		String result = requestResult.getResponse().getContentAsString();
		
		assertEquals("ok", result);
	}
	
}
















