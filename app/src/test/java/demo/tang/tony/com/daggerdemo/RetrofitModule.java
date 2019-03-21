package demo.tang.tony.com.daggerdemo;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = HiddenOkHttpClientModule.class)
class RetrofitModule {


    @Provides
    RestApi provideRestApi(Retrofit retrofit) {
        return retrofit.create(RestApi.class);
    }

    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient, String serverUrl, GsonConverterFactory factory) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(factory)
                .baseUrl(serverUrl)
                .build();
    }

    @Provides
    GsonConverterFactory factory() {
        return GsonConverterFactory.create();
    }
}