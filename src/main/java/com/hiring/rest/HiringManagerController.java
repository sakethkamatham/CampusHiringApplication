package com.hiring.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.service.HiringManagerApplicationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hiringmanager")
@Slf4j
public class HiringManagerController {
	
	private final HiringManagerApplicationService hiringManagerApplicationService;
	
}
