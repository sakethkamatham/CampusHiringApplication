package com.hiring.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.domain.Recruiter;
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
public class CampusService {

    private final RecruiterJpaRepository recruiterJpaRepository;
    private final RecruiterMapper recruiterMapper;

    public RecruiterResponseDTO getRecruiter(Long id) {
        Optional<Recruiter> recruiter = recruiterJpaRepository.findById(id);
        return recruiter.map(recruiterMapper::convertRecruiterToRecruiterResponseDTO).orElse(null);
    }

}

