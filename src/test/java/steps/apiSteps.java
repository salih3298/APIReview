package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.Constants;
import utils.Payload;

import static io.restassured.RestAssured.given;
import static steps.tokenReader.token;

public class apiSteps {

    public static final String BaseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    //because we need it in the nex calls
    //   String token;
    String employeeID;
    RequestSpecification request;
    Response response;


   /* @Given("a JWT is generated")
    public void a_jwt_is_generated() {
        request = given().header(Constants.Header_Content_Type_Key, Constants.Content_type_Value).
                body(Payload.generateTokenPayload());
        response = request.when().post(Constants.GENERATE_TOKEN_URI);
        String tok = response.jsonPath().getString("token");
        token = "Bearer " + tok;
    }*/

    @Given("a request is prepared to create an Employee")
    public void a_request_is_prepared_to_create_an_employee() {
        request = given().header(Constants.Header_Content_Type_Key, Constants.Content_type_Value).
                header(Constants.Header_Authorization_key, token).body(Payload.createEmployeePayload());
    }

    @When("a post call is made to the endpoint")
    public void a_post_call_is_made_to_the_endpoint() {
        response = request.when().post(Constants.CREATE_EMPLOYEE_URI);
    }

    @Then("the status code is {int}")
    public void the_status_code_is(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("the employee id {string} is stored as a global variable")
    public void the_employee_id_is_stored_as_a_global_variable(String empId) {
        employeeID = response.jsonPath().getString(empId);
    }

    @Then("we verify that the value for key {string} is {string}")
    public void we_verify_that_the_value_for_key_is(String key, String expectedValue) {
        String actualValue = response.jsonPath().getString(key);
        Assert.assertEquals(actualValue, expectedValue);
    }

    //*******************************************************************************
    @Given("a request is prepared to update an employee in HRMS system")
    public void a_request_is_prepared_to_update_an_employee_in_hrms_system() {
        request = given().header(Constants.Header_Content_Type_Key, Constants.Content_type_Value)
                .header(Constants.Header_Authorization_key, token)
                .body(Payload.updateEmployeePayload());
    }

    @When("a PUT call is made to update the employee")
    public void a_put_call_is_made_to_update_the_employee() {
        response = request.when().put(Constants.UPDATE_EMPLOYEE_URI);

    }

    @Then("the status code for updating the employee is {int}")
    public void the_status_code_for_updating_the_employee_is(int statuscode) {
        response.then().assertThat().statusCode(statuscode);

    }

    //**************************************************************************************
    @Given("a request is prepared to partially update an employee in HRMS system")
    public void a_request_is_prepared_to_partially_update_an_employee_in_hrms_system() {
        request = given().header(Constants.Header_Content_Type_Key, Constants.Content_type_Value)
                .header(Constants.Header_Authorization_key, token)
                .body(Payload.partiallyUpdateEmployeePayload());
    }

    @When("a PATCH call is made to partially update the employee")
    public void a_patch_call_is_made_to_partially_update_the_employee() {
        response = request.when().patch(Constants.PARTIALLY_UPDATE_EMPLOYEE_URI);
    }

    @Then("the response body contains {string} key and value {string}")
    public void the_response_body_contains_key_and_value(String key, String expectedMsg) {
        String message = response.jsonPath().getString(key);
        Assert.assertEquals(message, expectedMsg);
    }
}
