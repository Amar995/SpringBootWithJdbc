package com.config.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.config.Model.PublisherResult;
import com.config.service.TotalUserService;

@RestController
public class TotalStream {

	@Autowired
	private TotalUserService total;

	@GetMapping("/totalStream")
	public PublisherResult getTotalUser(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date startDate,
			@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date endDate,
			@RequestParam(required = false) String frequency, @RequestParam(required = false) String publisherName) {

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

		String sdate = date.format(startDate);
		String edate = date.format(endDate);

		PublisherResult result = null;
		if (sdate != null & edate != null || !sdate.isEmpty() & edate.isEmpty()) {
			result = total.getTotalStream(sdate, edate);
		} else if(frequency!=null || !frequency.isEmpty()){
			result=total.getTotalStream(frequency);
		}
		else if(publisherName!=null || !publisherName.isEmpty())
		{
			result=total.getTotalStreamByPublisherName(publisherName);
		}
		else
		{
			System.out.println("parameter can not be null");
		}
		return result;
	}
}
