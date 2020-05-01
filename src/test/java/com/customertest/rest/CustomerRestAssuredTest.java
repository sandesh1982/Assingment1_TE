package com.customertest.rest;

 import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.net.URISyntaxException;

import org.junit.Test;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

	    public class CustomerRestAssuredTest {
	    	String username = "technical";
	        String password = "Assessment";
	        
		 @Test
		 public void getCustomerTest() {
			 given().auth().preemptive().basic(username, password)
               .contentType(ContentType.JSON).
			 when().get("http://localhost:8080/customers/").then().statusCode(200);
		 }
		   @Test
		    public void testGetCustomerById() throws URISyntaxException {
		  		        
		           given().auth().preemptive().basic(username, password)
	               .contentType(ContentType.JSON).
				 when().get("http://localhost:8080/customers/getbyid/1").then().statusCode(200);
		    }
		   @Test
		    public  void testUpdateCustomer() throws URISyntaxException {
			   RestAssured.baseURI = "http://localhost:8080/customers/";
			    String requestBody ="{\r\n" +
		                " \"id\":\"1\",\r\n" +
		                " \"name\":\"Raj\",\r\n" +
		                " \"address\":\"Bangalore\"\r\n" +
		                "}";
		 		   Response response = null;
		 		        try {
		            response = RestAssured.given()
		                .contentType(ContentType.JSON).auth().preemptive().basic(username, password)
		                .body(requestBody)
		                .put("/update/1");
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		       	 assertEquals(200, response.getStatusCode());
		    }
		   @Test
		    public void testDeleteCustomer(){
		    RestAssured.baseURI = "http://localhost:8080/customers/";
		    Response response = null;
		   
	        try {
	            response = RestAssured.given()
	            	 .contentType(ContentType.JSON).auth().preemptive().basic(username, password)
	                .delete("/delete/3");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
	        System.out.println("Response :" + response.asString());
	        System.out.println("Status Code :" + response.getStatusCode());
	 
	    }
		   @Test
		    public void testCreateCustomer(){
			   RestAssured.baseURI = "http://localhost:8080/customers/";
		        String requestBody = "[{\n" +
		            "  \"id\": \"4\",\n" +
		            "  \"name\": \"Ritu\",\n" +
		            "  \"address\": \"Sadam\"\n" +
		            "}]s";
		 
		        Response response = null;
		 
		        try {
		            response = RestAssured.given()
		            	.contentType(ContentType.JSON).auth().preemptive().basic(username, password)
		                .body(requestBody)
		                .post("http://localhost:8080/customers/create");
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        System.out.println("Response :" + response.asString());
		        System.out.println("Status Code :" + response.getStatusCode());     	 
		        assertEquals(200, response.getStatusCode());
		    }
		   }
	    