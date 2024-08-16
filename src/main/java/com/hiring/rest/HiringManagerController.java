package com.hiring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.domain.HiringManager;
import com.hiring.domain.Recruiter;
import com.hiring.dto.HiringManagerRequestDTO;
import com.hiring.dto.RecruiterRequestDTO;
import com.hiring.service.HiringManagerApplicationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hiringmanager")
@Slf4j
public class HiringManagerController {
	
	private final HiringManagerApplicationService hiringManagerApplicationService;
	
	@PostMapping("/savehiringmanager")
    public ResponseEntity<HiringManager> saveRecruiter(@RequestBody HiringManagerRequestDTO hiringManagerRequestDTO) {
		try {
        HiringManager hiringManager = hiringManagerApplicationService.saveRecruiter(hiringManagerRequestDTO);
        return new ResponseEntity<>(hiringManager, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Error Saving new recruiter", e);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    }
	
}
