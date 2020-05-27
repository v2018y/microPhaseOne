package org.domain.component;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ErrorMessage {
	
	private Date timestamp;
	
	private String message;
	
	public ErrorMessage() {}

	
	public ErrorMessage(Date timestamp, String message) {
		this.timestamp = timestamp;
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
