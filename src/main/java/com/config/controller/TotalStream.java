package com.config.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


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
	public PublisherResult getTotalUser(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(defaultValue = "#{T(java.time.LocalDate).now()}") LocalDate startDate,
			@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(defaultValue = "#{T(java.time.LocalDate).now().withDayOfMonth(T(java.time.LocalDate).now().getMonth().length(T(java.time.LocalDate).now().isLeapYear()))}") LocalDate endDate,
			@RequestParam(required = false) String frequency, @RequestParam(required = false) String publisherName) {

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		
		Date sdate1=Date.valueOf(startDate);
		Date end=Date.valueOf(endDate);
		
		String sdate = date.format(sdate1);
		String edate = date.format(end);

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
