package demo.tang.tony.di;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
class HiddenOkHttpClientModule {

    @Provides
    OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }

}
