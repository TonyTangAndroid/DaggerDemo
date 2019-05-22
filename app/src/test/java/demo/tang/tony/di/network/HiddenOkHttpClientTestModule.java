package demo.tang.tony.di.network;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class HiddenOkHttpClientTestModule {

    @Provides
    OkHttpClient okHttpClient() {
        System.out.println("okHttpClient created");
        return new OkHttpClient();
    }

}
