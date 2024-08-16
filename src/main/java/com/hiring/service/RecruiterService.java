package com.hiring.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.domain.Recruiter;
import com.hiring.dto.RecruiterRequestDTO;
import com.hiring.dto.RecruiterResponseDTO;
import com.hiring.mapper.RecruiterMapper;
import com.hiring.repo.RecruiterJpaRepository;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class RecruiterService {

    private final RecruiterJpaRepository recruiterJpaRepository;
    private final RecruiterMapper recruiterMapper;

    public RecruiterResponseDTO getRecruiter(Long id) {
        Optional<Recruiter> recruiter = recruiterJpaRepository.findById(id);
        return recruiter.map(recruiterMapper::convertRecruiterToRecruiterResponseDTO).orElse(null);
    }

	public Recruiter saveRecruiter(RecruiterRequestDTO recruiterRequestDTO) {
		Recruiter recruiter =  Recruiter.builder()
				.name(recruiterRequestDTO.getName())
				.email(recruiterRequestDTO.getEmail())
				.build();
		return recruiterJpaRepository.save(recruiter);
	}

	public List<RecruiterResponseDTO> getAllRecruiter() {
		List<Recruiter> recruiters = recruiterJpaRepository.findAll();
		return recruiters.stream()
                .map(recruiterMapper::convertRecruiterToRecruiterResponseDTO)
                .collect(Collectors.toList());
	}

}

