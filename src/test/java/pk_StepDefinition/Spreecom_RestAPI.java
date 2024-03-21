package pk_StepDefinition;

import org.json.simple.JSONObject;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class Spreecom_RestAPI {
	String act_token;
	private RestAPI_Context stepData;

	// Now with just adding Constructor to RestAssuredAPIStepDefinition file and
	// pass
	// RestApi_TestContext as a Parameter to constructor would take all the pain.
	// Within the RestApi_TestContext object we have everything available which is
	// required for the test
	public Spreecom_RestAPI(RestAPI_Context stepData) {
		this.stepData = stepData;
	}

	@Given("User is on Spreecom Base URI Home Page")
	public void user_is_on_spreecom_base_uri_home_page() {

		RestAssured.baseURI = "https://demo.spreecommerce.org";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		stepData.httpRequest = RestAssured.given();
		// Write code here that turns the phrase above into concrete actions

	}

	@When("User pass the end points using GET keyword")
	public void user_pass_the_end_points_using_get_keyword() {
		// Write code here that turns the phrase above into concrete actions
		// This will return the Response from the server. Store the response in a
		// variable.
		stepData.response = stepData.httpRequest.request(Method.GET, "/api/v2/storefront/countries/default");

	}

	@Then("verify response should be {string}")
	public void verify_response_should_be(String statusCode) {
		// Write code here that turns the phrase above into concrete actions
		int expected_StatusCode = Integer.parseInt(statusCode);
		int act_StatusCode = stepData.response.getStatusCode();
		System.out.println("Status code is =>  " + act_StatusCode);
		Assert.assertEquals(expected_StatusCode, act_StatusCode);

	}

	@Then("verify iso_name should be {string}")
	public void verify_iso_name_should_be(String expected_CountryName) {
		
		String responseBody = stepData.response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		stepData.jsonPathEvaluator = new JsonPath(responseBody);
		String iso_act = stepData.jsonPathEvaluator.get("data.attributes.iso_name");
		System.out.println(iso_act);
		Assert.assertEquals(iso_act, expected_CountryName);
		// Write code here that turns the phrase above into concrete actions

	}
	
	@Given("^User is on RestCountries URI Home Page$")
	public void user_is_on_RestCountries_URI_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  // Specify the base URL to the RESTful web service
		  RestAssured.baseURI = "https://demo.spreecommerce.org/api/v2/storefront/countries";
		  
		  // Get the RequestSpecification of the request that you want to sent
		  // to the server. The server is specified by the BaseURI that we have
		  // specified in the above step.
		  stepData.httpRequest = RestAssured.given();
	}

	@When("^User Enter the keyword \"([^\"]*)\"$")
	public void user_Enter_the_keyword(String cname) throws Throwable {
	   // RestAssured httpRequest = null;
		// Write code here that turns the phrase above into concrete actions
		  // Make a request to the server by specifying the method Type and the method URL.
		  // This will return the Response from the server. Store the response in a variable.
		stepData.response = stepData.httpRequest.request(Method.GET, "/"+cname);
	}

	@Then("^verify body of the message to see what response return from server$")
	public void verify_body_of_the_message_to_see_what_response_return_from_server() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  // Now let us print the body of the message to see what response
		  // we have recieved from the server
		  String responseBody = stepData.response.getBody().asString();
		  System.out.println("Response Body is =>  " + responseBody);
	}

	@Then("^verify Status code return from server$")
	public void verify_Status_code_return_from_server() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  // Status Code Validation
		
		  int statusCode = stepData.response.getStatusCode();
		  System.out.println("Status code is =>  " + statusCode);
		  Assert.assertEquals(200, statusCode);
	}

	@Then("^verify Status Line return from server$")
	public void verify_Status_Line_return_from_server() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  // Status Line Verification
		  String statusLine = stepData.response.getStatusLine();
		  System.out.println("Status Line is =>  " + statusLine);
		//  Assert.assertEquals("HTTP/1.1 200", statusLine);
	}
	
	
	@Given("User send POST request for CreateToken using Base URI")
	public void user_send_post_request_for_create_token_using_base_uri() {
	    // Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI = "https://demo.spreecommerce.org";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		stepData.httpRequest = RestAssured.given();
		// Write code here that turns the phrase above into concrete actions
	}
	@When("User Enter the Body data as email id {string} and password {string}")
	public void user_enter_the_body_data_as_email_id_and_password(String email, String password) {
	    // Write code here that turns the phrase above into concrete actions
		JSONObject requestParams = new JSONObject();
        requestParams.put("grant_type", "password");
        requestParams.put("username", email);
        requestParams.put("password", password);
        // Add a header stating the Request body is a JSON
        stepData.httpRequest.header("Content-Type", "application/json");
        stepData.httpRequest.body(requestParams.toJSONString());
        // POST the Response
        stepData.response = stepData.httpRequest.request(Method.POST,"/spree_oauth/token");

	}
	@Then("verify it successfully generated the response with status code {string}")
	public void verify_it_successfully_generated_the_response_with_status_code(String Exp_Status_Code) {
	    // Write code here that turns the phrase above into concrete actions
		  // Status Code Validation
		  int statusCode = stepData.response.getStatusCode();
		  String scode=String.valueOf(statusCode);
		  System.out.println("Status code is =>  " + scode);
		  Assert.assertEquals(Exp_Status_Code, scode);
	}

	@Then("verify token return from server")
	public void verify_token_return_from_server() {
	    // Write code here that turns the phrase above into concrete actions
		  // we have recieved from the server
		 // Write code here that turns the phrase above into concrete actions
		  // we have recieved from the server
		String responseBody = stepData.response.getBody().asString();
		  System.out.println("Response Body is =>  " + responseBody);
		  stepData.jsonPathEvaluator = new JsonPath(responseBody);  
		  act_token = stepData.jsonPathEvaluator.get("access_token");
			System.out.println(act_token);
	}
	
	@When("User Enter the keyword from datatable {string}")
	public void user_enter_the_keyword_from_datatable(String iso) {
	    // Write code here that turns the phrase above into concrete actions
		stepData.response = stepData.httpRequest.request(Method.GET, "/"+iso);
	}
	@Then("verify iso_name return {string} from server")
	public void verify_iso_name_return_from_server(String Exp_iso_name) {
	    // Write code here that turns the phrase above into concrete actions
		
		String responseBody = stepData.response.getBody().asString();
		  System.out.println("Response Body is =>  " + responseBody);
		  stepData.jsonPathEvaluator = new JsonPath(responseBody);  
		  String iso_act = stepData.jsonPathEvaluator.get("data.attributes.iso_name");
			System.out.println(iso_act);
			Assert.assertEquals(iso_act,Exp_iso_name);
	    
	}
	@Given("User send POST request for Create Address")
	public void user_send_post_request_for_create_address() {
	    // Write code here that turns the phrase above into concrete actions
		 RestAssured.baseURI = "https://demo.spreecommerce.org";
		  
		  // Get the RequestSpecification of the request that you want to sent
		  // to the server. The server is specified by the BaseURI that we have
		  // specified in the above step.
		  stepData.httpRequest = RestAssured.given();
		  
	}
	@When("User Enter address details data through Body")
	public void user_enter_address_details_data_through_body() {
		JSONObject newAddress = new JSONObject();
		newAddress.put("firstname", "Abhi");
		newAddress.put("lastname", "dixit");
		newAddress.put("address1", "BTM");
		newAddress.put("city", "Qethesda");
		newAddress.put("zipcode", "90210");
		newAddress.put("phone", "3488545445002");
		newAddress.put("state_name", "CA");
		newAddress.put("country_iso", "US");
		JSONObject body = new JSONObject();
		body.put("address", newAddress);
		  // Add a header stating the Request body is a JSON
        stepData.httpRequest.header("Content-Type", "application/json");
        stepData.httpRequest.header("Authorization", "Bearer "+act_token);
        stepData.httpRequest.body(body.toJSONString());
	    // Write code here that turns the phrase above into concrete actions
		stepData.response = stepData.httpRequest.request(Method.POST, "/api/v2/storefront/account/addresses");
		   
	}
	@Then("verify the first and lastname of address returned by server")
	public void verify_the_first_and_lastname_of_address_returned_by_server() {
	    // Write code here that turns the phrase above into concrete actions
		String responseBody = stepData.response.getBody().asString();
		  System.out.println("Response Body is =>  " + responseBody);
		  stepData.jsonPathEvaluator = new JsonPath(responseBody);  
		  String fname = stepData.jsonPathEvaluator.get("data.attributes.firstname");
			System.out.println(fname);
			Assert.assertEquals(fname,"Abhi");
	}

}
