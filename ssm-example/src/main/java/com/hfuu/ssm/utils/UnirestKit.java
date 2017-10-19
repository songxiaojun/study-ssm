package com.hfuu.ssm.utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UnirestKit {
	public static String doPost(String url,String param){
		try {
			
			HttpResponse<JsonNode> jsonResponse = Unirest.post("url")
					.header("accept", "application/json")
					.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
