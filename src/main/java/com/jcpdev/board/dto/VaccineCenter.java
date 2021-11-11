package com.jcpdev.board.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class VaccineCenter {
	@JsonProperty
	private String address;
	@JsonProperty
	private String centerName;
	@JsonProperty
	private String facilityName;
	@JsonProperty
	private String zipcode;
	@JsonProperty
	private String phoneNumber;
	
}
