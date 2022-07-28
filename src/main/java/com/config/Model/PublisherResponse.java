package com.config.Model;

import java.util.Date;
import java.util.List;

public class PublisherResponse {
	private Date date;
	private List<Publisher> publisher;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Publisher> getPublisher() {
		return publisher;
	}

	public void setPublisher(List<Publisher> publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "PublisherResponse [date=" + date + ", publisher=" + publisher + "]";
	}
}
