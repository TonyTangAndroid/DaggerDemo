package demo.tang.tony.com.daggerdemo;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;


public class NetworkChannel {

    private OkHttpClient client;

    public NetworkChannel(OkHttpClient client) {
        this.client = client;
    }

    public Person execute(Request request) throws IOException {
//        try (Response response = client.newCall(request).execute()) {
//            assert response.body() != null;
//            return response.body().string();
//        }

        throw new RuntimeException();
    }
}