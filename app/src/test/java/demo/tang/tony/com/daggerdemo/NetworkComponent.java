package demo.tang.tony.com.daggerdemo;

import dagger.Component;
import okhttp3.Request;

@Component(modules = {PublicNetworkModule.class, RequestModule.class})
public interface NetworkComponent {

    void inject(NetworkTest test);

    Request request();
}