package com.jcpdev.board;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jcpdev.board.entity.Users;
import com.jcpdev.board.repository.UsersRepository;

@SpringBootTest
class Boot7JpaApplicationTests {
	
	@Autowired
	UsersRepository udao;
	
	@Test
	public void update() {
        Users member=Users.builder()
        		.mno(2L)
        		.email("serii@jcp.kr")
        		.name("세리park" )
        		.build();
        udao.save(member);
  }
	
	void insertUsers() {
		//자바 람다식
		IntStream.range(1, 6).forEach(i -> {
			Users member = Users.builder()
					.email("momo"+i+"@naver.com")
					.password("2222"+(i*12))
					.name("김모모"+i)
					.build();
			udao.save(member);
					
		});
	}
	
	void insertUser() {
		Users user = Users.builder()
				.email("momo@gmail.com")
				.password("1111")
				.name("momo")
				.build();
		udao.save(user);		//save 메소드는 insert, update sql 동작 같이 사용				
	}
	
	
}
