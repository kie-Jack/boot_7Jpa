package com.jcpdev.board.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity			//이 클래스는 테이블과 바로 매핑되는 엔티티 입니다.
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString(callSuper = true)
@Table(name="board")	//board 테이블과 매핑됩니다. 클래스명과 동일하면 생략가능.
public class Board extends BaseEntity{
	//테이블의 컬럼과 매핑되도록 선언합니다.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bidx;		//int는 10자리정수 (21억)	
	
	//@Column
	private String subject;
	private String content;
	
	@ManyToOne				// 다대일 : 한 사용자가 여러개 글을 작성할 수 있음.
	private Users writer;	// 단방향 관계 설정 (Users 에는 관계 설정 안함)
							// 실제 테이블에서 외래키 설정한 관계
//	34번 라인에 따라 테이블 컬럼명은 writer_mno
}
