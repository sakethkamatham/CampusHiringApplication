package com.hiring.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(value = Include.NON_NULL)
public class NotesRequestDTO {
	
	private String candidate_name;
	
	private String candidate_email;
	
	private String content;
	
	private String university_name;
	
}
