package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Steps {

	private static Response response;
	private static String jsonString;

	@Given("when API is called with correct loanappUuid {string}")
	public void when_API_is_called_with_correct_loanappUuid(String loanAppUuid) {
		RestAssured.baseURI = "https://credapi.credify.tech/api/brfunnelorch/v2/resume";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loanAppUuid", loanAppUuid);
		map.put("skipSideEffects", true);

		response = given().urlEncodingEnabled(true).contentType(ContentType.JSON).body(map)
				.headers("x-cf-source-id", "coding-challenge")
				.headers("x-cf-corr-id", "c548c700-e20f-11eb-8ac8-03a1c35ec434")
				.headers("Content-Type", "application/json").post("/byLeadSecret").then().extract()
				.response();

		ResponseBody body = response.getBody();
	}

	@Then("Respose status code should be {int}")
	public void respose_status_code_should_be(Integer statusCode) {
		int status = response.getStatusCode();
		Assert.assertTrue("Invalid Response code", status == statusCode);

	}

	@Then("response should include {string} for productType")
	public void response_should_include_for_productType(String PERSONAL_LOAN) {
		jsonString = response.asString();
		JsonPath jsonPathEvaluator = response.jsonPath();
		String prodtype = jsonPathEvaluator.get("loanAppResumptionInfo.productType");

		Assert.assertEquals("both same", prodtype, PERSONAL_LOAN);

	}

	@Then("when I pass different loanAppUuid {string} then error code {int} is received")
	public void when_I_pass_different_loanAppUuid_then_error_code_is_received(String incorrectLoanAppUuid,
			Integer statuscode) {
		when_API_is_called_with_correct_loanappUuid(incorrectLoanAppUuid);
		int status = response.getStatusCode();
		Assert.assertTrue("Valid Response code", status == statuscode);

	}

}
