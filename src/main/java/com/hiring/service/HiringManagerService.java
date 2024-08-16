package com.hiring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.domain.HiringManager;
import com.hiring.dto.HiringManagerRequestDTO;
import com.hiring.repo.HiringManagerJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class HiringManagerService {
	
	private final HiringManagerJpaRepository hiringManagerJpaRepository;
	
	public HiringManager saveRecruiter(HiringManagerRequestDTO hiringManagerRequestDTO) {
		HiringManager hiringManager = HiringManager.builder().email(hiringManagerRequestDTO.getEmail())
				.name(hiringManagerRequestDTO.getName()).build();		
		return hiringManagerJpaRepository.save(hiringManager);
	}

}
