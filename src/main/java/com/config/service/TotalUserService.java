package com.config.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.Model.Publisher;
import com.config.Model.PublisherResponse;
import com.config.Model.PublisherResult;
import com.config.Model.TotalSteam;
import com.config.dao.StreamDurationDao;

@Service
public class TotalUserService {

	@Autowired
	private StreamDurationDao dao;

	public int getTotalUser(String startDate, String endDate) {
		return dao.getTotalUser(startDate, endDate);
	}

	public PublisherResult getTotalStream(String startDate, String endDate) {
		List<TotalSteam> st = dao.getTotalStream(startDate, endDate);

		PublisherResult result = new PublisherResult();
		Publisher publisher = new Publisher();
		PublisherResponse res1 = new PublisherResponse();
		List<PublisherResponse> res = result.getResult();
		for (TotalSteam to : st) {
			publisher.setName(to.getPublisher_name());
			publisher.setTotalStream(to.getTotalstreams());

			res1.setDate(to.getStart_date());
			res1.getPublisher().add(publisher);

			res.add(res1);
			
		}
		result.setResult(res);

		return result;
	}
	public PublisherResult getTotalStream(String frequency) {
		List<TotalSteam> st = dao.getTotalStream(frequency);

		PublisherResult result = new PublisherResult();
		Publisher publisher = new Publisher();
		PublisherResponse res1 = new PublisherResponse();
		List<PublisherResponse> res = result.getResult();
		for (TotalSteam to : st) {
			publisher.setName(to.getPublisher_name());
			publisher.setTotalStream(to.getTotalstreams());

			res1.setDate(to.getStart_date());
			res1.getPublisher().add(publisher);

			res.add(res1);
			
		}
		result.setResult(res);

		return result;
	}
	public PublisherResult getTotalStreamByPublisherName(String publisherName) {
		List<TotalSteam> st = dao.getTotalStreambypublisherName(publisherName);

		PublisherResult result = new PublisherResult();
		Publisher publisher = new Publisher();
		PublisherResponse res1 = new PublisherResponse();
		List<PublisherResponse> res = result.getResult();
		for (TotalSteam to : st) {
			publisher.setName(to.getPublisher_name());
			publisher.setTotalStream(to.getTotalstreams());

			res1.setDate(to.getStart_date());
			res1.getPublisher().add(publisher);

			res.add(res1);
			
		}
		result.setResult(res);

		return result;
	}
	public int getTotalStreamDuration() {
		return 0;

	}
}
