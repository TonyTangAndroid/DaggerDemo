package demo.tang.tony.com.daggerdemo;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module(includes = HiddenOkHttpClientModule.class)
class PublicNetworkModule {

    @Provides
    NetworkChannel networkRequest(OkHttpClient okHttpClient) {
        return new NetworkChannel(okHttpClient);
    }

}
