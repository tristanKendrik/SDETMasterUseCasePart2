import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class GetREST {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts/";

    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            // GET Request
        	 String baseUrl = "https://jsonplaceholder.typicode.com/posts/";

             // Define the post ID you want to retrieve
             int postId = 1; // Change this to the desired post ID

             // Create a GET request object with the specific post ID
             String url = baseUrl + postId;
             HttpGet request = new HttpGet(url);

             // Execute the request and capture the response
             CloseableHttpResponse response = httpClient.execute(request);

             // Read and print the response
             BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
             String line;
             StringBuilder result = new StringBuilder();
             while ((line = reader.readLine()) != null) {
                 result.append(line);
             }
             System.out.println(result.toString());

             // Close the response and HttpClient
             response.close();

            // POST Request
            HttpPost postRequest = new HttpPost(BASE_URL);
            postRequest.setHeader("Content-Type", "application/json");
            StringEntity postEntity = new StringEntity("{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}");
            postRequest.setEntity(postEntity);
            CloseableHttpResponse postResponse = httpClient.execute(postRequest);
            System.out.println("POST Response: " + EntityUtils.toString(postResponse.getEntity()));
            postResponse.close();

            // PUT Request
            HttpPut putRequest = new HttpPut(BASE_URL + "1");
            putRequest.setHeader("Content-Type", "application/json");
            StringEntity putEntity = new StringEntity("{\"id\":1,\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}");
            putRequest.setEntity(putEntity);
            CloseableHttpResponse putResponse = httpClient.execute(putRequest);
            System.out.println("PUT Response: " + EntityUtils.toString(putResponse.getEntity()));
            putResponse.close();

            // PATCH Request
            HttpPatch patchRequest = new HttpPatch(BASE_URL + "1");
            patchRequest.setHeader("Content-Type", "application/json");
            StringEntity patchEntity = new StringEntity("{\"title\":\"foo\"}");
            patchRequest.setEntity(patchEntity);
            CloseableHttpResponse patchResponse = httpClient.execute(patchRequest);
            System.out.println("PATCH Response: " + EntityUtils.toString(patchResponse.getEntity()));
            patchResponse.close();

            // DELETE Request
            HttpDelete deleteRequest = new HttpDelete(BASE_URL + "1");
            CloseableHttpResponse deleteResponse = httpClient.execute(deleteRequest);
            System.out.println("DELETE Response: " + EntityUtils.toString(deleteResponse.getEntity()));
            deleteResponse.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
