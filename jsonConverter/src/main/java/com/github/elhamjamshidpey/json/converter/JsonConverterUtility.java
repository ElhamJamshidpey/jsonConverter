package com.github.elhamjamshidpey.json.converter;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


/*
 * Utility for converting object to json standard format and vice versa 
 * @author elham.jamshidpey@gmail.com on 05/11/2018
 */
public class JsonConverterUtility {
	
	private static ObjectMapper mapper = new ObjectMapper();

	/*
	 * convert object to string in beautify and simple standard json format
	 * use BigDecimal for float numbers
	 * JsonParserException is expected
	 */
	public static String objectToJson(Object obj,boolean beautify) throws JsonProcessingException {
        return beautify ? mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj):
        	   	mapper.writeValueAsString(obj);
	}
	
	/*
	 * convert string in json beautify and simple standard format to object
	 * convert float numbers to BigDecimal 
	 * JsonParseException, JsonMappingException, IOException are expected
	 */
	public static Object jsonToObject(String json) throws JsonParseException, JsonMappingException, IOException  {
		mapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS,true);
		return mapper.readValue(json, Object.class);
	}
	
	/*
	 * convert string in json beautify and simple standard format to specific object
	 * Unknown properties are ignore  
	 * convert float numbers to BigDecimal 
	 * JsonParseException, JsonMappingException, IOException are expected
	 */
	public static <T> T jsonToObject(String json,Class<T> object) throws JsonParseException, JsonMappingException, IOException  {
		mapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS,true);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		return (T) mapper.readValue(json, object);
	}
	
	/*
	 * convert specific part of string in json beautify and simple standard format to specific object
	 * Unknown properties are ignore  
	 * convert float numbers to BigDecimal 
	 * JsonParseException, JsonMappingException, IOException are expected
	 */
	public static <T> Object jsonToObject(String json,Class<T> object,String node) throws JsonParseException, JsonMappingException, IOException {
		mapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS,true);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		JsonNode jsonNode = mapper.readTree(json).get(node);
		return mapper.treeToValue(jsonNode, object);
	}
	
}
