package com.wwegoo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ExceptionHandlerModel {
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date timestamp;
	private String error;
	private String error_description;
	
	public ExceptionHandlerModel(Date timestamp, String error, String description) {
		super();
		this.timestamp = timestamp;
		this.error = error;
		this.error_description = description;
	}
}
