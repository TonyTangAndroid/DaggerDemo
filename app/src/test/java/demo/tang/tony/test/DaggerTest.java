package demo.tang.tony.test;

import org.junit.Test;

import demo.tang.tony.di.network.DaggerNetworkComponent;


public class DaggerTest {


    @Test(expected = IllegalStateException.class)
    public void addition_isCorrect() {
        DaggerNetworkComponent.builder().build();
    }

}