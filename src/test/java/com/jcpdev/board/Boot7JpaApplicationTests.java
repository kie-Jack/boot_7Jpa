package com.jcpdev.board;

import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jcpdev.board.entity.Board;
import com.jcpdev.board.entity.Users;
import com.jcpdev.board.repository.BoardRepository;
import com.jcpdev.board.repository.UsersRepository;

@SpringBootTest
class Boot7JpaApplicationTests {

	@Autowired
	UsersRepository udao;

	@Autowired
	BoardRepository bdao;

	// Jpa + 3rd Party 라이브러리
	@Test
	public void getBoardOne() {
		System.out.println(bdao.findById(3L));
	}
	
	
	public void insertBoard() {
		for (int i = 1; i < 20; i++) {
			Random random = new Random();
			// random.nextInt(9) 메소드는 0 <= 랜덤 < 9, Long.valueOf : int를 Long 타입 변환
			Users user = Users.builder()
					.mno(Long.valueOf(random.nextInt(4) + 3))
					.build();
			Board board = Board.builder()
					.subject("제목" + i)
					.content("내용" + i + "테스트" + (i * 11))
					.writer(user)
					.build();
			bdao.save(board);
		}
	}

	public void delete() {
		udao.deleteById(2L); // delete : 기본키값 delete조건에 해당합니다.
	}

	public void getOne() {
//		Optional 타입은 Users 타입의 Wrapper
//		users 객체가 null 일때, 메소드 실행 NullPointerException은 발생 안합니다.
		Optional<Users> users = udao.findById(8L);
		// select 쿼리 where 기본키값 조건 검색에 해당하는 메소드
		Users user = null;

//		if(users.isPresent())	user = users.get();	1)
//		else user = new Users();

		user = users.orElse(new Users()); // 2) 위의 2문장을 대신하는 메소드
///		*테스트 : findById 없는 기본키값 일때 1)과 2) 비교
//		orElse()메소드는 users가 null 일때 Users 객체를 생성하여 반환합니다.
//		null 이 아니면 users가 참조하는 Users 객체를 반환합니다.
		System.out.println(user);
		System.out.println(users);
	}

	public void update() {
		Users member = Users.builder().mno(2L).email("serii@jcp.kr").name("세리park").build();
		udao.save(member);
	}

	void insertUsers() {
		// 자바 람다식
		IntStream.range(1, 6).forEach(i -> {
			Users member = Users.builder().email("momo" + i + "@naver.com").password("2222" + (i * 12)).name("김모모" + i)
					.build();
			udao.save(member);

		});
	}

	void insertUser() {
		Users user = Users.builder().email("momo@gmail.com").password("1111").name("momo").build();
		udao.save(user); // save 메소드는 insert, update sql에 해당합니다
	}

}
