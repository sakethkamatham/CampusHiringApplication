package com.hiring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.domain.Notes;
import com.hiring.dto.NotesRequestDTO;
import com.hiring.dto.NotesResponseDTO;
import com.hiring.service.NotesApplicationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
@Slf4j
public class NotesController {
	
	private final NotesApplicationService notesApplicationService;
	
	@PostMapping("/savenotes")
	public ResponseEntity<NotesResponseDTO> saveNotesWithCandidate(@RequestBody NotesRequestDTO notesRequestDTO) {
	    try {
	        Notes notes = notesApplicationService.saveNotesWithCandidate(notesRequestDTO);
	        NotesResponseDTO notesResponseDTO = NotesResponseDTO.builder().noteId(notes.getId())
	        		.noteContent(notes.getContent())
	        		.candidateId(notes.getCandidate().getId())
	        		.candidateName(notes.getCandidate().getName())
	        		.candidateEmail(notes.getCandidate().getEmail())
	        		.university(notes.getUniversity().getUniversity_name())
	        		.build();
	        return new ResponseEntity<>(notesResponseDTO, HttpStatus.CREATED);
	    } catch (Exception e) {
	        log.error("Error saving notes with candidate", e);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}


}
