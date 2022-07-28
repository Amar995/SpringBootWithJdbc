package com.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.config.service.TotalUserService;

@RestController
public class StreamingDurationController {

	@Autowired
	private TotalUserService total;

	public int getTotalStreamDuration() {
		return 0;

	}
}
