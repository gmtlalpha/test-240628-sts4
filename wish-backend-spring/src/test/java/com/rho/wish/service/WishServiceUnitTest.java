package com.rho.wish.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rho.wish.repository.WishRepository;
import com.rho.wish.service.WishService;

//UT Service 관련 IoC에 메모리애 띄우고 테스트
@ExtendWith(MockitoExtension.class)
public class WishServiceUnitTest {
	
	@InjectMocks // wishService객체가 만들어질때 여기에 @Mock써있는모든애들을 DI함
	private WishService wishService;
	
	@Mock
	private WishRepository wishRepository;
}
