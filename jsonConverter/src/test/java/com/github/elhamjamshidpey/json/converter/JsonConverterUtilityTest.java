package com.github.elhamjamshidpey.json.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.elhamjamshidpey.json.converter.JsonConverterUtility;

public class JsonConverterUtilityTest{

	private Sample obj;
	private String json;
	private String beautifiedJson;

	@Before
	public void init() {
		List<String> strings = new ArrayList<String>();
		strings.add("A");
		strings.add("B");
		strings.add("C");
		List<Inner> innerObj = new ArrayList<Inner>();

		Inner i1 = new Inner();
		i1.addString("a");
		i1.addString("b");
		i1.addString("c");
		i1.setS("s1");
		innerObj.add(i1);

		Inner i2 = new Inner();
		i2.addString("d");
		i2.addString("e");
		i2.addString("f");
		i2.setS("s2");
		innerObj.add(i2);
		
		BigDecimal b = new BigDecimal(1.2).setScale(1, BigDecimal.ROUND_HALF_UP);
		
		Set<String> stringList = new HashSet<String>();
		stringList.add("a");
		stringList.add("b");
		stringList.add("c");
		obj = new Sample(strings, 12, b, "D", innerObj,stringList , i1);
		json = "{\"stringList\":[\"A\",\"B\",\"C\"],\"integerValue\":12,\"bigDecimalValue\":1.2,\"stringValue\":\"D\","
				+ "\"innerObjectList\":[{\"stringList\":[\"a\",\"b\",\"c\"],\"s\":\"s1\"},{\"stringList\":[\"d\",\"e\",\"f\"],\"s\":\"s2\"}],"
				+ "\"stringSet\":[\"a\",\"b\",\"c\"],\"innerObject\":{\"stringList\":[\"a\",\"b\",\"c\"],\"s\":\"s1\"}}";
		beautifiedJson = "{\r\n" + 
				"  \"stringList\" : [ \"A\", \"B\", \"C\" ],\r\n" + 
				"  \"integerValue\" : 12,\r\n" + 
				"  \"bigDecimalValue\" : 1.2,\r\n" + 
				"  \"stringValue\" : \"D\",\r\n" + 
				"  \"innerObjectList\" : [ {\r\n" + 
				"    \"stringList\" : [ \"a\", \"b\", \"c\" ],\r\n" + 
				"    \"s\" : \"s1\"\r\n" + 
				"  }, {\r\n" + 
				"    \"stringList\" : [ \"d\", \"e\", \"f\" ],\r\n" + 
				"    \"s\" : \"s2\"\r\n" + 
				"  } ],\r\n" + 
				"  \"stringSet\" : [ \"a\", \"b\", \"c\" ],\r\n" + 
				"  \"innerObject\" : {\r\n" + 
				"    \"stringList\" : [ \"a\", \"b\", \"c\" ],\r\n" + 
				"    \"s\" : \"s1\"\r\n" + 
				"  }\r\n" + 
				"}";
	}

	@Test
	public void ConvertObjectToBeautifyJson_thenOk() {
		String result = "";
		try {
			result = JsonConverterUtility.objectToJson(obj,true);
			assertEquals(beautifiedJson, result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void ConvertObjectToJson_thenOk() {
		String result = "";
		try {
			result = JsonConverterUtility.objectToJson(obj,false);
			assertEquals(json, result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	
    @Test
	public void convertBeautifyJsonToObject_thenOk() {
    	try {
			Object result = JsonConverterUtility.jsonToObject(beautifiedJson);
    		assertNotNull(result);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
    
    
    @Test
	public void convertBeautifyJsonToSpecificObject_thenOk() {
    	try {
    		Sample result = (Sample) JsonConverterUtility.jsonToObject(beautifiedJson, Sample.class);
    		assertEquals(obj, result);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
    @Test
   	public void convertJsonToSpecificObject_thenOk() {
       	try {
       		Sample result = (Sample) JsonConverterUtility.jsonToObject(json, Sample.class);
       		assertEquals(obj, result);
   		} catch (JsonParseException e) {
   			e.printStackTrace();
   		} catch (JsonMappingException e) {
   			e.printStackTrace();
   		} catch (IOException e) {
   			e.printStackTrace();
   		}
       }
   	
    @Test
   	public void convertJsonAndGetSpecificNode_thenOk() {
       	try {
       		Inner result = (Inner) JsonConverterUtility.jsonToObject(json,Inner.class,"innerObject");
       		assertEquals(obj.getInnerObject(), result);
   		} catch (JsonParseException e) {
   			e.printStackTrace();
   		} catch (JsonMappingException e) {
   			e.printStackTrace();
   		} catch (IOException e) {
   			e.printStackTrace();
   		}
       }
   	
}
