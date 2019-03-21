package demo.tang.tony.com.daggerdemo;

import org.junit.Test;


public class DaggerTest {


    @Test(expected = IllegalStateException.class)
    public void addition_isCorrect() {
        DaggerNetworkComponent.builder().build();
    }

}