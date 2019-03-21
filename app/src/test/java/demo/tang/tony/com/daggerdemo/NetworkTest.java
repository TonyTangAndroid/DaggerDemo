package demo.tang.tony.com.daggerdemo;

import org.junit.Test;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static org.junit.Assert.assertEquals;


public class NetworkTest {
    @Test
    public void addition_isCorrect() throws IOException {
        assertEquals(expected(), actual());
    }

    private String actual() throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://www.mocky.io/v2/5c9302e0320000e51c6bd167")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }

    }

    private String expected() {
        return "{\"name\":\"tony\"}";
    }
}