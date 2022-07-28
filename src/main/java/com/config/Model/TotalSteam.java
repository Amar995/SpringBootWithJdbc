package com.config.Model;

import java.util.Date;

public class TotalSteam {

	private int totalstreams;
	private Date start_date;
	private int publisher_id;
	private String publisher_name;
	public int getTotalstreams() {
		return totalstreams;
	}
	public void setTotalstreams(int totalstreams) {
		this.totalstreams = totalstreams;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public int getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}
	public String getPublisher_name() {
		return publisher_name;
	}
	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}
}
