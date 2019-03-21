package demo.tang.tony.com.daggerdemo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import static org.junit.Assert.assertEquals;


public class NetworkTest {

    private OkHttpClient client;

    @Before
    public void setup() {
        client = new OkHttpClient();

    }

    @Test
    public void addition_isCorrect() throws IOException {
        Request request = new Request.Builder()
                .url("http://www.mocky.io/v2/5c9302e0320000e51c6bd167")
                .build();
        NetworkRequest networkRequest = new NetworkRequest(client);
        for (int i = 0; i < 10; i++) {
            System.out.println("count:" + i);
            assertEquals(expected(), networkRequest.execute(request));
        }
    }


    private String expected() {
        return "{\"name\":\"tony\"}";
    }
}