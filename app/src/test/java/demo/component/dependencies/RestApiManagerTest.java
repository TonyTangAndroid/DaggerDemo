package demo.component.dependencies;

import org.junit.Test;

import retrofit2.Retrofit;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RestApiManagerTest {

    @Test
    public void createRestApi() {

        Retrofit retrofit = mock(Retrofit.class);
        RestApiManager restApiManager = new RestApiManager(retrofit, null);
        RestApi restApi = restApiManager.createRestApi(RestApi.class);
        verify(retrofit).create(any());

    }
}