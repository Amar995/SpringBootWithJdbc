package com.config.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.config.service.TotalUserService;

@RestController
public class TotalUsersController {

	@Autowired
	private TotalUserService total;

	@GetMapping("/totalUser")
	public int getTotalUser(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(defaultValue = "#{T(java.time.LocalDate).now()}") LocalDate startDate,
			@DateTimeFormat(pattern = "yyyy-MM-dd")@RequestParam(defaultValue = "#{T(java.time.LocalDate).now().withDayOfMonth(T(java.time.LocalDate).now().getMonth().length(T(java.time.LocalDate).now().isLeapYear()))}") LocalDate endDate) {
		
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
		Date sdate1=Date.valueOf(startDate);
		Date end=Date.valueOf(endDate);

		String sdate=date.format(sdate1);
		String edate=date.format(end);
		
        System.out.println(sdate+"   "+edate);
		int totalUser=0;
		if(sdate !=null &edate!=null )
		{
			totalUser=total.getTotalUser(sdate, edate);
		}
		else
		{
			System.out.println("startDate and endDate can not be null or empty");
		}
		return totalUser;
	}
}
