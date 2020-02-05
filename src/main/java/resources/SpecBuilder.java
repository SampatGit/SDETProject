package resources;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import io.restassured.builder.RequestSpecBuilder;

import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Body;
import utils.JsonPojo;

import java.sql.*;

public class SpecBuilder {


	//	public static final String ProfileRI = "/rest/api/profile/138";


	public Response setRequest(String BasePath) {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		RequestSpecification requestspec;


		builder.setBaseUri("http://okmry52647dns.eastus.cloudapp.azure.com:8089");
		builder.setBasePath(BasePath);
		builder.setAccept("application/json");
		builder.setContentType("application/json");

		requestspec = builder.build();
		System.out.println("BUILD successfull");
		Response response = given(requestspec).when().get().then().extract().response();
		System.out.println(response.getStatusCode());
		return response;



	}

	


		//System.out.println(poj.getBody().toString());










		//		
		//		
		//     	ObjectMapper mapper = new ObjectMapper()
		//     	mapper.
		//     	JsonNode node = mapper.valueToTree(resp);
		//     	System.out.println(node.fieldNames());
		//     	JsonPojo toValue = mapper.convertValue(node, JsonPojo.class);
		//     	System.out.println(toValue.getBody());


		//		String resstr = resp.toString()
		//		Gson gson = new Gson();
		//		Map map = gson.fromJson(resp, JsonPojo.class);
		//		JsonPojo jpoj = gson.fromJson("", JsonPojo.class);
		//		
		//		for (JsonPojo jpojo : jpoj) {
		//			for(Body bodyData : jpoj.getBody()) {
		//				if(bodyData.getEmailId().contains("sdet113")) {
		//					System.out.println("id is"+ bodyData.getUserId());
		//				}
		//			}
		//		}

		//		List<String> emails = resp.path("body[*].emailId");
		//		Iterator ids = emails.iterator();
		//		while(ids.hasNext()) {
		//			String emailId = (String) ids.next();
		//			if(emailId.contains(userEmail)) {

	}



