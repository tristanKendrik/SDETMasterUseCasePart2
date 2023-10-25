package stepDefinition;
import org.testng.annotations.*;
import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.entity.StringEntity;

public class NewTest {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts/";

    private CloseableHttpClient httpClient;

   @BeforeClass
    public void setUp() {
        httpClient = HttpClients.createDefault();
    }

    @AfterClass
    public void tearDown() {
        try {
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetRequest() throws Exception {
        HttpGet getRequest = new HttpGet(BASE_URL + "1");
        CloseableHttpResponse getResponse = httpClient.execute(getRequest);
        String responseBody = EntityUtils.toString(getResponse.getEntity());
        Assert.assertEquals(getResponse.getStatusLine().getStatusCode(), 200);
        Assert.assertTrue(responseBody.contains("\"id\": 1"));
        getResponse.close();
    }

    @Test
    public void testPostRequest() throws Exception {
        HttpPost postRequest = new HttpPost(BASE_URL);
        postRequest.setHeader("Content-Type", "application/json");
        StringEntity postEntity = new StringEntity("{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}");
        postRequest.setEntity(postEntity);
        CloseableHttpResponse postResponse = httpClient.execute(postRequest);
        String responseBody = EntityUtils.toString(postResponse.getEntity());
        Assert.assertEquals(postResponse.getStatusLine().getStatusCode(), 201);
        Assert.assertTrue(responseBody.contains("\"title\": \"foo\""));
        postResponse.close();
    }

    // Add similar test methods for PUT, PATCH, and DELETE requests
}
