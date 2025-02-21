package com.rho.wish.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import com.rho.wish.repository.WishRepository;

//UT DB관련된 Beand IoC에 등록됨

@Transactional
@AutoConfigureTestDatabase(replace = Replace.ANY) // 가짜DB로 테스트 , Replace.NONE은 실제DB
@DataJpaTest // Repositorye들을 IoC에 등록해둠.
public class WishRepositoryUnitTest {

	@Autowired
	private WishRepository wishRepository;
}
