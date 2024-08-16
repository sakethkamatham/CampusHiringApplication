package com.hiring.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.domain.Candidate;
import com.hiring.domain.Notes;
import com.hiring.domain.University;
import com.hiring.dto.NotesRequestDTO;
import com.hiring.repo.CandidateJpaRepository;
import com.hiring.repo.NotesJpaRepository;
import com.hiring.repo.UniversityJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class NotesService {
	
	private final NotesJpaRepository notesJpaRepository;
	
	private final CandidateJpaRepository candidateJpaRepository;
	
	private final UniversityJpaRepository universityJpaRepository;

	public Notes saveNotesWithCandidate(NotesRequestDTO notesRequestDTO) {
		
		Candidate candidate = candidateJpaRepository.findByEmailAndName(notesRequestDTO.getCandidate_email(),notesRequestDTO.getCandidate_name())
                .orElseGet(() -> {
                    Candidate newCandidate = Candidate.builder()
                    		.name(notesRequestDTO.getCandidate_name())
                    		.email(notesRequestDTO.getCandidate_email())
                    		.build();
                    return candidateJpaRepository.save(newCandidate);
                });
		log.info("University name is ",notesRequestDTO);
		
		University university = universityJpaRepository.findByUniversityName(notesRequestDTO.getUniversity_name())
				.orElseGet(() -> {
					University newUniversity = University.builder()
							.university_name(notesRequestDTO.getUniversity_name())
							.build();
					return universityJpaRepository.save(newUniversity);
				});
		
		Notes notes = Notes.builder()
				.content(notesRequestDTO.getContent())
				.comment_time(LocalDateTime.now())
				.candidate(candidate)
				.university(university)
				.build();
		
		return notesJpaRepository.save(notes);
	}

}
