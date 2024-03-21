package pk_StepDefinition;

import org.json.simple.JSONObject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPI_Context {
	
	protected Response response;
	protected RequestSpecification httpRequest;
	protected JsonPath jsonPathEvaluator;
	protected JSONObject jsonObject;

}
