package demo.tang.tony.com.daggerdemo;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
class NetworkModule {

    @Provides
    NetworkRequest networkRequest(OkHttpClient okHttpClient) {
        return new NetworkRequest(okHttpClient);
    }

}
