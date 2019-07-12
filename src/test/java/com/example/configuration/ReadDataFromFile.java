package com.example.configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ReadDataFromFile {

	private static ObjectMapper mapper;

	private static final String JSON_FOLDER = "src/test/resources/DATA/";

	public static <T> T getObjectFromJson(String jsonFileName, Class<T> clazz) {
		mapper = new ObjectMapper();
		T t = null;
		String filePath = JSON_FOLDER + jsonFileName;
		try {
			String jsonString = new String(Files.readAllBytes(Paths.get(filePath)), "UTF-8");
			t = mapper.readValue(jsonString, clazz);
		} catch (JsonParseException e) {
			System.out.println(e.getMessage());
		} catch (JsonMappingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return t;
	}
}
