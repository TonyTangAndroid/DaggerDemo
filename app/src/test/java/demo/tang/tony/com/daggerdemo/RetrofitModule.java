package demo.tang.tony.com.daggerdemo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;

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

    @Named("basic")
    @Provides
    Gson basic() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(TestTonyMyAdapterFactory.create());
        return gsonBuilder.create();
    }

    @Provides
    Gson gson(@Named("basic") Gson gson) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(NestName.class, new CustomJsonDeserializer(gson));
        gsonBuilder.registerTypeAdapterFactory(TestTonyMyAdapterFactory.create());
        return gsonBuilder.create();
    }

    @Provides
    GsonConverterFactory factory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }
}