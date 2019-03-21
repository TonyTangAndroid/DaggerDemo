package demo.tang.tony.com.daggerdemo;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
class OkHttpClientModule {

    @Provides
    OkHttpClient create1() {
        return new OkHttpClient();
    }

    @Provides
    NetworkRequest networkRequest(OkHttpClient okHttpClient) {
        return new NetworkRequest(okHttpClient);
    }

}
