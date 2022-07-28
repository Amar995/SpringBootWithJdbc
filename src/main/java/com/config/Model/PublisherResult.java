package com.config.Model;

import java.util.List;

public class PublisherResult {

	private List<PublisherResponse> result;

	public List<PublisherResponse> getResult() {
		return result;
	}

	public void setResult(List<PublisherResponse> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "PublisherResult [result=" + result + "]";
	}
}
