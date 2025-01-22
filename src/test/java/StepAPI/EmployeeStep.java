package StepAPI;

import org.hamcrest.Matchers;

import BaseAPILayer.BaseApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class EmployeeStep extends BaseApi{
	
	Response response;
	ValidatableResponse validateResponse;

	@Given("user set base uri")
	public void user_set_base_uri() 
	{
		RestAssured.baseURI = "http://localhost:3333/";
	}

	@Given("user set {string} base path")
	public void user_set_base_path(String basePath) 
	{
		RestAssured.basePath = basePath;
	}

	@Given("user get the request specification object")
	public void user_get_the_request_specification_object() 
	{
		BaseApi.reqSpec();
	}

	@Given("user add employee id {string} as path parameter")
	public void user_add_employee_id_as_path_parameter(String employeeId) 
	{
		httpRequest.pathParam("id", employeeId);	
	}

	
	@Then("user get validatable reponse interface object")
	public void user_get_validatable_reponse_interface_object() 
	{
		validateResponse = response.then().assertThat();
	}

	@Then("user validate status code {int}")
	public void user_validate_status_code(Integer code)
	{
		validateResponse.statusCode(Matchers.equalTo(code));
	}

	@Then("user validate status line {string}")
	public void user_validate_status_line(String line) 
	{
		validateResponse.statusLine(Matchers.containsString(line));
	}

	@Then("user validate response time {int} ms")
	public void user_validate_response_time_ms(Integer time) 
	{
		validateResponse.time(Matchers.lessThan((long) time));
	}

	@Then("user generate response logs")
	public void user_generate_response_logs() 
	{
		validateResponse.log().all();
	}
	
	@When("user select http delete request to delete employee single entity")
	public void user_select_http_delete_request_to_delete_employee_single_entity() 
	{	    
		response = httpRequest.delete("{id}");
	}
	
	
	@Given("user add employee query parameter {string} and {string}")
	public void user_add_employee_query_parameter_and(String keyName, String value) 
	{	    
		httpRequest.queryParam(keyName, value);
	}
	
	@When("user select http get request to retrieve all employee entity")
	public void user_select_http_get_request_to_retrieve_all_employee_entity() 
	{
		response = httpRequest.get();
	}
	
	@When("user select http get request to retrieve employee single entity")
	public void user_select_http_get_request_to_retrieve_employee_single_entity() 
	{
		response = httpRequest.get("{id}");
	}
 
}

 
	
	
	


