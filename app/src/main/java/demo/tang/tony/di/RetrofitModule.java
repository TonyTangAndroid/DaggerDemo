package demo.tang.tony.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import demo.tang.tony.api.PresidentApi;
import demo.tang.tony.api.StudentApi;
import demo.tang.tony.api.TeacherApi;
import demo.tang.tony.model.TestTonyMyAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
class RetrofitModule {


    @Provides
    StudentApi provideRestApi(Retrofit retrofit) {
        return retrofit.create(StudentApi.class);
    }

    @Provides
    TeacherApi provideTeacherApi(Retrofit retrofit) {
        return retrofit.create(TeacherApi.class);
    }

    @Provides
    PresidentApi providePresidentApi(Retrofit retrofit) {
        return retrofit.create(PresidentApi.class);
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