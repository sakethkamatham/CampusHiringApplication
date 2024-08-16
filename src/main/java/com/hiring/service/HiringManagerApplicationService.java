package com.hiring.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.domain.HiringManager;
import com.hiring.dto.HiringManagerRequestDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Component
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class HiringManagerApplicationService {
	
	private final HiringManagerService hiringManagerService;
	
	public HiringManager saveRecruiter(HiringManagerRequestDTO hiringManagerRequestDTO) {
		return hiringManagerService.saveRecruiter(hiringManagerRequestDTO);
	}

}
