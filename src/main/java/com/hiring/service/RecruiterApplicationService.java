package com.hiring.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.domain.Recruiter;
import com.hiring.dto.RecruiterRequestDTO;
import com.hiring.dto.RecruiterResponseDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Component
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class RecruiterApplicationService {
	
	
	private final RecruiterService recruiterService;

	public RecruiterResponseDTO getRecruiter(Long id) {
		return recruiterService.getRecruiter(id);
	}
	

	public Recruiter saveRecruiter(RecruiterRequestDTO recruiterRequestDTO) {
		return recruiterService.saveRecruiter(recruiterRequestDTO);
	}
	

	public List<RecruiterResponseDTO> getAllRecruiter() {
		return recruiterService.getAllRecruiter();
	}

}
