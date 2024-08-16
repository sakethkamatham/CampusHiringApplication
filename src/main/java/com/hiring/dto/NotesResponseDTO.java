package com.hiring.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(value = Include.NON_NULL)
public class NotesResponseDTO {
	
	private Long noteId;
	
	private String noteContent;
	
	private Long candidateId;
	
	private String candidateName;
	
	private String candidateEmail;
	
	private String university;
	

}
