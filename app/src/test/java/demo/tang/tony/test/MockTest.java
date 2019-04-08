package demo.tang.tony.test;

import com.google.common.truth.Truth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;


public class MockTest {

    private MockWebServer mockWebServer;

    @Before
    public void setup() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();

    }

    @After
    public void tearDown() throws IOException {
        mockWebServer.shutdown();
    }


    @Test
    public void test_mock() throws IOException {
        MockResponse mockResponse = new MockResponse().setResponseCode(200).setBody("{\"name\":\"Tony\"}");
        mockWebServer.enqueue(mockResponse);
        OkHttpClient client = new OkHttpClient();
        Request request = request();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        Truth.assertThat(result).isEqualTo("{\"name\":\"Tony\"}");
    }

    private Request request() {
        Request.Builder builder = new Request.Builder();
        HttpUrl httpUrl = mockWebServer.url("/");
        System.out.println(httpUrl.toString());
        builder.url(httpUrl);
        return builder.build();
    }


}