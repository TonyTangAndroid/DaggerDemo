package demo.motif.expose;

import com.google.common.truth.Truth;

import org.junit.Test;

import motif.Scope;

public class Scratch {


    @Test
    public void with_factory() {
        RootScope rootScope = new RootScopeFactoryImpl().create("abc");
        String actual = rootScope.request().execute();
        Truth.assertThat(actual).isEqualTo("abc:success");
    }

    @Test
    public void without_factory() {
        RootScope rootScope =new RootScopeImpl(() -> "abc");
        String actual = rootScope.request().execute();
        Truth.assertThat(actual).isEqualTo("abc:success");
    }


}