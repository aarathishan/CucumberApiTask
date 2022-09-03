package org.google.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.google.objectrepository.AddLocation;
import org.google.objectrepository.Location;
import org.google.resources.APIResources;
import org.google.resources.Commonutils;
import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class GoogleSteps extends Commonutils{
	
	AddLocation loc;
	Commonutils c=new Commonutils();
	
	@Given("I want to add payload")
	public void i_want_to_add_payload() {
		
		loc=new AddLocation();
		
		Location l = new Location();
		l.setLat("-38.383494");
		l.setLng("33.427362");
		loc.setLocation(l);
		loc.setAccuracy(50);
		loc.setAddress("Bangalore");
		loc.setName("Technology");
		loc.setPhone_number("7795545388");
		List<String> li=new ArrayList<String>();
		li.add("software");
		li.add("training");
		loc.setTypes(li);
		loc.setWebsite("http://www.details.com/");
		loc.setLanguage("English");
	    
	}
     
	Response response;
	RequestSpecification requset;
	@When("User submit {string} api")
	public void user_submit_api(String string) throws FileNotFoundException {
		
		c.requestSpecDif();
		
		requset=given().spec(requestDiffApproach).body(loc);
			    
	}

	@Then("User validate the status code is {int}")
	public void user_validate_the_status_code_is(Integer int1) {
		
		ResponseSpecification response2=c.response();
		APIResources resource=APIResources.valueOf("addPlaceApi");
		response= requset.when().post(resource.getResource())
		        .then().spec(response2).extract().response();
		
		int int2=response.getStatusCode();
		
		String s=String.valueOf(int2);
		
		Assert.assertEquals(int1.toString(),s);
	    
	}

}
