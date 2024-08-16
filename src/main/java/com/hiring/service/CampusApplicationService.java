package com.hiring.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.dto.RecruiterResponseDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Component
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class CampusApplicationService {
	
	
	private final CampusService campusService;

	public RecruiterResponseDTO getRecruiter(Long id) {
		
		return campusService.getRecruiter(id);
	}

}
