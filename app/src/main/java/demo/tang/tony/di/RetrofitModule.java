package demo.tang.tony.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import demo.tang.tony.api.PresidentApi;
import demo.tang.tony.api.StudentApi;
import demo.tang.tony.api.TeacherApi;
import demo.tang.tony.com.daggerdemo.AppScope;
import demo.tang.tony.model.TestTonyMyAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    //
    //
    //okHttpClient created Gson created
    //OkHttpClient  GsonConverterFactory
    //
    //Retrofit
    //
    //StudentApi

    @AppScope
    @Provides
    StudentApi provideRestApi(Retrofit retrofit) {
        System.out.println("StudentApi created");
        return retrofit.create(StudentApi.class);
    }

    @AppScope
    @Provides
    TeacherApi provideTeacherApi(Retrofit retrofit) {
        System.out.println("TeacherApi created");
        return retrofit.create(TeacherApi.class);
    }

    @AppScope
    @Provides
    PresidentApi providePresidentApi(@Named("external") Retrofit retrofit) {
        System.out.println("PresidentApi created");
        return retrofit.create(PresidentApi.class);
    }

    @AppScope
    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient, String serverUrl,
                             GsonConverterFactory factory) {
        System.out.println("Retrofit created");

        return new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(factory)
                .baseUrl(serverUrl)
                .build();
    }

    @AppScope
    @Provides
    @Named("external")
    Retrofit provideRetrofit2(OkHttpClient okHttpClient, String serverUrl,
                              GsonConverterFactory factory) {
        System.out.println("Retrofit created external");

        return new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(factory)
                .baseUrl(serverUrl)
                .build();
    }

    @AppScope
    @Provides
    Gson gson() {
        System.out.println("Gson created");
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(TestTonyMyAdapterFactory.create());
        return gsonBuilder.create();
    }

    @AppScope
    @Provides
    GsonConverterFactory factory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }
}