package com.config.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	public int getTotalUser(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam Date startDate,@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam Date endDate) {
		
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
		
		String sdate=date.format(startDate);
		String edate=date.format(endDate);
		
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
