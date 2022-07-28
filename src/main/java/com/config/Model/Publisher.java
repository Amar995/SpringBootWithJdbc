package com.config.Model;

public class Publisher {
	private int totalStream;
	private String name;

	public int getTotalStream() {
		return totalStream;
	}

	public void setTotalStream(int totalStream) {
		this.totalStream = totalStream;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Publisher [totalStream=" + totalStream + ", name=" + name + "]";
	}
}
