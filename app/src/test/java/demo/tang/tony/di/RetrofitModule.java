package demo.tang.tony.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import demo.tang.tony.api.RestApi;
import demo.tang.tony.api.TeacherApi;
import demo.tang.tony.model.TestTonyMyAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
class RetrofitModule {


    @Provides
    RestApi provideRestApi(Retrofit retrofit) {
        return retrofit.create(RestApi.class);
    }

    @Provides
    TeacherApi provideTeacherApi(Retrofit retrofit) {
        return retrofit.create(TeacherApi.class);
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
    Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(TestTonyMyAdapterFactory.create());
        return gsonBuilder.create();
    }

    @Provides
    GsonConverterFactory factory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }
}