package stepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class GetTEST {

    @Given("I send a GET request to {string}")
    public void i_send_a_get_request_to(String url) {
        // Write code here to send a GET request to the provided URL
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        // Write code here to verify the response status code
    }

    @Then("the response body should contain {string}")
    public void the_response_body_should_contain(String expectedContent) {
        // Write code here to verify that the response body contains the expected content
    }

    @Given("I send a POST request to {string} with the following JSON:")
    public void i_send_a_post_request_to_with_the_following_json(String url, String jsonBody) {
        // Write code here to send a POST request to the provided URL with the JSON body
    }
}
