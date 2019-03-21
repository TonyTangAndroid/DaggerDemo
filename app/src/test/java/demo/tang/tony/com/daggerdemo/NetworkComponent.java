package demo.tang.tony.com.daggerdemo;

import dagger.Component;

@Component(modules = {PublicNetworkModule.class})
public interface NetworkComponent {

    NetworkRequest networkRequest();
}