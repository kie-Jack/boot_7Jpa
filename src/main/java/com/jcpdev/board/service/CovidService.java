package com.jcpdev.board.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcpdev.board.dto.RootInfo;
import com.jcpdev.board.dto.VaccineCenter;

@Service
public class CovidService {
	
	
	public String readString() {
		return vaccCenterRead();
	}
	
	public List<VaccineCenter> readObject() {
		String json = vaccCenterRead();
		List<VaccineCenter> list=null;
		try {
			list = objectMake(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return list;
	}

	private String vaccCenterRead() {

		String json = "";

		try {

			// 인증키 (개인이 받아와야함)
			String serviceKey = "HlhazDVmPvr%2F2mQYI11wJOM0KdUXiZQ0D0N3sy%2F6qq6qvaFUhxSqi0Beqj7DEywor0gBBEbmkI7Lb9U4gOOhLg%3D%3D";
			String page = "2";
			String perPage = "20";
			URL url = new URL("https://api.odcloud.kr/api/15077586/v1/centers?serviceKey=" + serviceKey + "&page="
					+ page + "&perPage=" + perPage);

			BufferedReader bf;
			String r = "";
			// url 로 지정한 요청으로부터 받은 json 데이터를 1줄씩 읽어서 string으로 연결하기
			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			while ((r = bf.readLine()) != null) {

				json = json.concat(r);
			}

			System.out.println(json); // 스트링 json
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return json;
	}
	
	public List<VaccineCenter> objectMake(String json) throws JsonMappingException, JsonProcessingException{

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // java 오브젝트에 없는 프로퍼티로 생기는 오류
																					// 발생하지 않도록 설정
		RootInfo root = mapper.readValue(json, RootInfo.class); // json 과 매핑되는 오브젝트를 만들어야 하는것이 중요함.(RootInfo,
																// VaccinCenter)

		// 객체로 매핑된 결과 출력
		for (VaccineCenter vacc : root.getData())
			System.out.println(vacc);
		
		return root.getData();
	}
	
	
}
