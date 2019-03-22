package demo.motif.expose;

import com.google.common.truth.Truth;

import org.junit.Test;

public class GrandchildTest {

    @Test
    public void create_child() {

        RootScope rootScope = new RootScopeFactoryImpl().create("abc");
        ChildScope child = rootScope.createChild("1");
        GrandchildScope grandchildScope = child.create();
        GrandchildController grandchildController = grandchildScope.grandchildController();
        String actual = grandchildController.request();
        Truth.assertThat(actual).isEqualTo("childChildId");

    }


  @Test
    public void auth_token() {

        RootScope rootScope = new RootScopeFactoryImpl().create("abc");
        Truth.assertThat(rootScope.authToken().getAccessToken()).isEqualTo("abc");
    }

}