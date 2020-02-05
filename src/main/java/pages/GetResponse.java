package pages;

import java.util.List;


import resources.Common;
import resources.SpecBuilder;


import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import utils.JsonPojo;

public class GetResponse {

	 SpecBuilder builder = new SpecBuilder();

    //This test will fetch the User ID of n user based on the email id
	
	public int GetUserID() throws JsonMappingException, JsonProcessingException {


		Response resp = builder.setRequest(Common.AllProfilePath); 
		int userId = 0;
		String pathforEmail = "body.emailId";
		String datastr = resp.asString();
		ObjectMapper mapper = new ObjectMapper();
		mapper.readValue(datastr, JsonPojo.class);
		List<String> emails = resp.getBody().jsonPath().get(pathforEmail);
		System.out.println(emails);


		for(int id=0; id< emails.size(); id ++) {
			if(emails.get(id).toString().contains(Common.email)) {
			    int TuserId =	resp.getBody().jsonPath().get("body["+id+"].userId");
				
				userId = TuserId;
			}
        
		}
		System.out.println("id is"+userId);
		return userId;
		}
	
	
}
