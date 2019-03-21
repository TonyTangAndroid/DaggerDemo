package demo.tang.tony.com.daggerdemo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Request;

import static org.junit.Assert.assertEquals;


public class NetworkTest {

    @Inject
    NetworkRequest networkRequest;

    @Before
    public void setup() {
        DaggerNetworkComponent.create().inject(this);
    }

    @Test
    public void addition_isCorrect() throws IOException {
        Request request = new Request.Builder()
                .url("http://www.mocky.io/v2/5c9302e0320000e51c6bd167")
                .build();
        for (int i = 0; i < 1; i++) {
            System.out.println("count:" + i);
            assertEquals(expected(), networkRequest.execute(request));
        }
    }


    private String expected() {
        return "{\"name\":\"tony\"}";
    }
}