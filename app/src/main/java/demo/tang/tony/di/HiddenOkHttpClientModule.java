package demo.tang.tony.di;

import dagger.Module;
import dagger.Provides;
import demo.tang.tony.com.daggerdemo.AppScope;
import okhttp3.OkHttpClient;

@Module
public class HiddenOkHttpClientModule {

    @AppScope
    @Provides
    OkHttpClient okHttpClient() {
        System.out.println("okHttpClient created");
        return new OkHttpClient();
    }

}
