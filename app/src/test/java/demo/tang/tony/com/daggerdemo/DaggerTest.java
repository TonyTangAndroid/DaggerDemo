package demo.tang.tony.com.daggerdemo;

import org.junit.Test;

import java.io.IOException;


public class DaggerTest {


    @Test
    public void addition_isCorrect() throws IOException {

        NetworkComponent networkComponent1 = DaggerNetworkComponent.create();
        NetworkComponent networkComponent2 = DaggerNetworkComponent.builder().build();


    }


    private String expected() {
        return "{\"name\":\"tony\"}";
    }
}