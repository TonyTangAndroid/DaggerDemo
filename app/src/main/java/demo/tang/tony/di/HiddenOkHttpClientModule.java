package demo.tang.tony.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class HiddenOkHttpClientModule {

    @Singleton
    @Provides
    OkHttpClient okHttpClient() {
        System.out.println("okHttpClient created");
        return new OkHttpClient();
    }

}
