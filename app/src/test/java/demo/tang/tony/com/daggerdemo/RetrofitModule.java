package demo.tang.tony.com.daggerdemo;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {


    @Provides
    RestApi provideRestApi(Retrofit retrofit) {
        return retrofit.create(RestApi.class);
    }

    @Provides
    Retrofit provideRetrofit(String serverUrl, GsonConverterFactory factory) {
        return new Retrofit.Builder()
                .addConverterFactory(factory)
                .baseUrl(serverUrl)
                .build();
    }

    @Provides
    GsonConverterFactory factory() {
        return GsonConverterFactory.create();
    }
}