package com.eastcom_sw.rs;

import java.util.Map;

import org.hw.sml.core.SqlMarkupAbstractTemplate;
import org.hw.sml.rest.annotation.SmlResource;
import org.hw.sml.support.ioc.annotation.Bean;
import org.hw.sml.support.ioc.annotation.Inject;

import com.eastcom_sw.Person;

@SmlResource("sml")
@Bean
public class Rs {
	@Inject
	private SqlMarkupAbstractTemplate sqlMarkupAbstractTemplate;
	@Inject("person")
	private Person person;
	
	@SmlResource("person")
	public Person getP(){
		return person;
	}
	@SmlResource("query")
	public Object query(Map<String,String> objs){
		return sqlMarkupAbstractTemplate.getSmlContextUtils().query(objs);
	}
}
