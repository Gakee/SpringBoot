package com.xin.domain;

import java.io.Serializable;

public class Test implements Serializable{

	private static final long serialVersionUid = 1L;
	
	private Integer id;
	
	private String name;

	private String notest;

	private String test1;

	private String code;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
