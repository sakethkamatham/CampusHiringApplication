package com.hiring.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(value = Include.NON_NULL)
public class RecruiterResponseDTO implements Serializable{
	
	private static final long serialVersionUID = 860272362746482655L;

	private Long id;
	
	private String name;
	
	private String email;

}
