package com.jcpdev.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "customer")
public class CustomerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idx;
	@Column(updatable = false)
	private String name;
	
	@Column(updatable = false)
	private String password;
	
	private String email;
	private String addr;

	@Column
	private String gender;			
	
	private Integer age;		//entity는 기본형 대신 래퍼클래스 타입으로 선언하세요.
								//값이 없으면 null 로 처리. -> 기본형은 null 대입이 안됩니다.
	private String hobby;		
}
