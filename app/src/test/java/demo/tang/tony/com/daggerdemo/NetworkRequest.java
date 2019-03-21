package demo.tang.tony.com.daggerdemo;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class NetworkRequest {

    private OkHttpClient client;

    public NetworkRequest(OkHttpClient client) {
        this.client = client;
    }

    public String execute(Request request) throws IOException {
        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            return response.body().string();
        }
    }
}