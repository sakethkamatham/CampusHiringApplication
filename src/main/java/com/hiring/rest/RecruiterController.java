package com.hiring.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.domain.Recruiter;
import com.hiring.dto.RecruiterRequestDTO;
import com.hiring.dto.RecruiterResponseDTO;
import com.hiring.service.RecruiterApplicationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recruiter")
@Slf4j
public class RecruiterController {
	
	private final RecruiterApplicationService recruiterApplicationService;
	
	@GetMapping("getrecruiter/{id}")
	public ResponseEntity<RecruiterResponseDTO> getRecruiter(@PathVariable Long id) {
	    try {
	        RecruiterResponseDTO recruiterResponseDTO = recruiterApplicationService.getRecruiter(id);
	        if (recruiterResponseDTO != null) {
	            return ResponseEntity.ok(recruiterResponseDTO);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } catch (Exception e) {
	    	log.error("An Error Has Occured" , e);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}	
	
	
	
	@PostMapping("/saverecruiter")
    public ResponseEntity<Recruiter> saveRecruiter(@RequestBody RecruiterRequestDTO recruiterRequestDTO) {
		try {
        Recruiter recruiter = recruiterApplicationService.saveRecruiter(recruiterRequestDTO);
        return new ResponseEntity<>(recruiter, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Error Saving new recruiter", e);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    }
	
	
	@GetMapping("/getAllRecruiters")
	public ResponseEntity<List<RecruiterResponseDTO>> getAllRecruiter() {
	    try {
	        List<RecruiterResponseDTO> recruiterResponseDTO = recruiterApplicationService.getAllRecruiter();
	        if (recruiterResponseDTO.isEmpty()) {
	        	return ResponseEntity.notFound().build();
	        } else {
	            return ResponseEntity.ok(recruiterResponseDTO);
	        }
	    } catch (Exception e) {
	    	log.error("An Error Has Occured" , e);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
	    
}