package demo.tang.tony.com.daggerdemo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static org.junit.Assert.assertEquals;


public class NetworkTest {

    private OkHttpClient client;
    private Request request;

    @Before
    public void setup() {
        client = new OkHttpClient();
        request = new Request.Builder()
                .url("http://www.mocky.io/v2/5c9302e0320000e51c6bd167")
                .build();
    }

    @Test
    public void addition_isCorrect() throws IOException {
        for (int i = 0; i < 10; i++) {
            System.out.println("count:" + i);
            assertEquals(expected(), actual(client));
        }
    }

    private String actual(OkHttpClient client) throws IOException {


        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }

    }

    private String expected() {
        return "{\"name\":\"tony\"}";
    }
}