package com.jcpdev.board.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jcpdev.board.service.CovidService;


@RestController
public class COVIDController {
// OPEN API에서 json 데이터 받아오고 자바 클래스와 매핑하는 예시

	@Autowired
	CovidService service;			
											//받아오는 데이터 한글일 때 처리
	@RequestMapping(value = "/covid",produces="text/html;charset=utf-8")
	@ResponseBody
	public String center() {
		String json = service.readString();
		/*
		Map<String,Object> result = new HashMap<>();
		Boolean state;
		if(json == null) state=false;
		else state=true;
		result.put("result", state);
		result.put("data", json);
		*/
		return json;
	}
	
	
}
