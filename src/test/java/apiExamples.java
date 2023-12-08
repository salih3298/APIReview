import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class apiExamples {


    // Set the base URI
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MDE5MDk3MDEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcwMTk1MjkwMSwidXNlcklkIjoiNjA4MCJ9.g_4qKHMLbsR7JqI-kviRUq3vcY49s8FrzZ-v8LcDgak";

    @Test
    public void createAnEmployee() {
        //prepare request

        RequestSpecification request = given().header("Content-Type", "application/json").header("Authorization", token).
                body("{\n" +
                        "  \"emp_firstname\": \"Anıl\",\n" +
                        "  \"emp_lastname\": \"Aygun\",\n" +
                        "  \"emp_middle_name\": \"Kucuk\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2005-01-26\",\n" +
                        "  \"emp_status\": \"Trying\",\n" +
                        "  \"emp_job_title\": \"SDET\"\n" +
                        "}");

        //send the request to the endpoint
        Response response = request.when().post("/createEmployee.php");
        response.prettyPrint();
        String resp = response.then().extract().body().asString();
        System.out.println(resp);

        // extract the value of the key message
        String message = response.jsonPath().getString("Message");

        //assertion
        Assert.assertEquals(message, "Employee Created");

        String fname = response.jsonPath().getString("Employee.emp_firstname");
        Assert.assertEquals(fname, "Anıl");

    }


}
