package demo.tang.tony.com.daggerdemo;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {RetrofitModule.class})
public interface NetworkComponent {

    RestApi restApi();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder url(String url);

        NetworkComponent build();
    }
}