package com.hiring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.hiring.domain.Recruiter;
import com.hiring.dto.RecruiterResponseDTO;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface RecruiterMapper {
	
	RecruiterResponseDTO convertRecruiterToRecruiterResponseDTO(Recruiter recruiter);

}
