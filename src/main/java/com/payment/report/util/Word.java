package com.payment.report.util;

import java.io.Serializable;

public class Word implements Serializable{
	
	private String key;
	private String[] value = new String[1];
	private String delimitter = ";";
	
	public Word() {
		this.key = "Hello";
		this.value[0] = "World";
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String[] getValue() {
		return value;
	}

	public void setValue(String[] value) {
		this.value = value;
	}

	public String getDelimitter() {
		return delimitter;
	}

	public void setDelimitter(String delimitter) {
		this.delimitter = delimitter;
	}

}
