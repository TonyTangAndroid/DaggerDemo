package demo.tang.tony.com.daggerdemo;

import dagger.Component;
import okhttp3.OkHttpClient;

@Component(modules = OkHttpClientModule.class)
public interface NetworkComponent {

    //output
    OkHttpClient okHttpClient();
}