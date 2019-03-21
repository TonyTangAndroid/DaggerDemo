package demo.tang.tony.com.daggerdemo;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
class OkHttpClientModule {

    @Provides
    OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }


}
