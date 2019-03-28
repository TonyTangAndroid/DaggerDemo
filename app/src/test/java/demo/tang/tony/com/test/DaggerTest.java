package demo.tang.tony.com.test;

import org.junit.Test;

import demo.tang.tony.com.daggerdemo.DaggerNetworkComponent;


public class DaggerTest {


    @Test(expected = IllegalStateException.class)
    public void addition_isCorrect() {
        DaggerNetworkComponent.builder().build();
    }

}