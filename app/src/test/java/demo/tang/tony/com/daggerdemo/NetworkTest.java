package demo.tang.tony.com.daggerdemo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertEquals;


public class NetworkTest {

    public static final String URL = "http://www.mocky.io/v2/5c9302e0320000e51c6bd167";


    @Inject
    Request request;

    @Inject
    NetworkChannel networkChannel;

    @Before
    public void setup() {
        DaggerNetworkComponent.builder().url(URL).build().inject(this);
    }

    @Test
    public void addition_isCorrect() throws IOException {
        for (int i = 0; i < 1; i++) {
            System.out.println("count:" + i);
//            assertEquals(expected(), actual1());
            assertEquals(expected(), actual2());
        }
    }

    private Person actual2() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://www.mocky.io/v2/")
                .build();

        RestApi restApi = retrofit.create(RestApi.class);

        Call<Person> personCall = restApi.get("5c9302e0320000e51c6bd167");
        Response<Person> response = personCall.execute();
        Person person = response.body();
        return person;
    }

    private Person actual1() throws IOException {
        return networkChannel.execute(request);
    }


    private Person expected() {
        Person person = new Person();
        person.name = "tony";
        return person;
    }
}