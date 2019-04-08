package demo.tang.tony.model;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

@GsonTypeAdapterFactory
public abstract class TestTonyMyAdapterFactory implements TypeAdapterFactory {

    // Static factory method to access the package
    // private generated implementation
    public static TypeAdapterFactory create() {
        return new AutoValueGson_TestTonyMyAdapterFactory();
    }
    //                      1:N            1:N
    //activity -> presenter ---> use case -----> repo -> rest api
//                                            |1:1
//                                            cache
//                                             |1:1
//                                             db
}