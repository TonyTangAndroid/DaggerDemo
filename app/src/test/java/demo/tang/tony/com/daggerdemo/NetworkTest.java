package demo.tang.tony.com.daggerdemo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Request;

import static org.junit.Assert.assertEquals;


public class NetworkTest {

    public static final String URL = "http://www.mocky.io/v2/5c9302e0320000e51c6bd167";


    @Inject
    Request request;

    @Inject
    NetworkChannel networkChannel;

    @Before
    public void setup() {
        DaggerNetworkComponent.builder().url(URL).build().inject(this);
    }

    @Test
    public void addition_isCorrect() throws IOException {
        for (int i = 0; i < 1; i++) {
            System.out.println("count:" + i);
            assertEquals(expected(), networkChannel.execute(request));
        }
    }


    private String expected() {
        return "{\"name\":\"tony\"}";
    }
}