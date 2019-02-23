package com.example.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {

	private String value;

	public HttpUtil(String value) {
		this.value = value;
	}

	public static HttpUtil of(BufferedReader br) {
		StringBuilder str = new StringBuilder();
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				str.append(line);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return null;
		}
		return new HttpUtil(str.toString());
	}

	public <T> T toModel(Class<T> clazz) {
		try {
			return new ObjectMapper().readValue(this.value, clazz);
		} catch (JsonParseException e) {
			return null;
		} catch (JsonMappingException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	public String getValue() {
		return this.value;
	}
}
