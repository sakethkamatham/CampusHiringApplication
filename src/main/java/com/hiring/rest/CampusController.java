package com.hiring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.dto.RecruiterResponseDTO;
import com.hiring.service.CampusApplicationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recruitment")
@Slf4j
public class CampusController {
	
	private final CampusApplicationService campusApplicationService;
	
	@GetMapping("/{id}")
	public ResponseEntity<RecruiterResponseDTO> getRecruiter(@PathVariable Long id) {
	    try {
	    	log.info("Started");
	        RecruiterResponseDTO recruiterResponseDTO = campusApplicationService.getRecruiter(id);
	        if (recruiterResponseDTO != null) {
	        	log.info("Inside If");
	            return ResponseEntity.ok(recruiterResponseDTO);
	        } else {
	        	log.info("Inside Else");
	            return ResponseEntity.notFound().build();
	        }
	    } catch (Exception e) {
	    	log.error("An Error Has Occured" , e);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}	
}