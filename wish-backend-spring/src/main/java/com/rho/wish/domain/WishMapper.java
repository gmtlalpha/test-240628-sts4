/**
 * 
 */
package com.rho.wish.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @Mapper: 마이바티스의 매퍼 인터페이스를 나타내는 어노테이션입니다. 
 * 이 어노테이션을 사용하면 XML 파일 없이 인터페이스에서 직접 SQL 쿼리를 작성할 수 있습니다.
 * @Select, @Insert, @Update, @Delete: SQL 쿼리를 지정하는 어노테이션입니다. 
 * 각각 SELECT, INSERT, UPDATE, DELETE 쿼리에 사용됩니다. 
 * 이러한 어노테이션들은 @Mapper 인터페이스 내의 메서드에 적용됩니다.
 * @Results: 쿼리 결과를 도메인 객체에 매핑하는 어노테이션입니다. 
 * @Result 어노테이션을 사용해 컬럼과 객체의 속성을 연결할 수 있습니다.
 */
@Mapper
public interface WishMapper {

List<Wish> readWishAll();
	
	Wish readWishOne(Long id);
	
	void createWish(Wish wish);
	
	void updateWish(Long id, Wish wish);
	
	void deleteWishOne(Long id);
	
}
