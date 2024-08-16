package com.hiring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.domain.Notes;
import com.hiring.dto.NotesRequestDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class NotesApplicationService {
	
	private final NotesService notesService;

	public Notes saveNotesWithCandidate(NotesRequestDTO notesRequestDTO) {
		return notesService.saveNotesWithCandidate(notesRequestDTO);
	}

}
