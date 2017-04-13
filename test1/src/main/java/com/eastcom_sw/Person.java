package com.eastcom_sw;

import org.hw.sml.support.ioc.annotation.Bean;
import org.hw.sml.support.ioc.annotation.Init;
import org.hw.sml.support.ioc.annotation.Val;

@Bean
public class Person {
	@Val("id")
	private int id;
	@Val("name")
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	@Init
	public void init(){
		System.out.println(this);
	}
}
