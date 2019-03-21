package demo.tang.tony.com.daggerdemo;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {PublicNetworkModule.class, RequestModule.class})
public interface NetworkComponent {

    void inject(NetworkTest test);


    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder url(String url);

        NetworkComponent build();
    }
}