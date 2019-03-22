package demo.motif.expose;

import com.google.common.truth.Truth;

import org.junit.Test;

public class ChildTest {

    @Test
    public void create_child() {

        RootScope rootScope = new RootScopeFactoryImpl().create("abc");
        ChildScope child = rootScope.createChild("1");
        Controller controller = child.controller();
        String actual = controller.request();
        Truth.assertThat(actual).isEqualTo("1:abc:success");

    }


  @Test
    public void auth_token() {

        RootScope rootScope = new RootScopeFactoryImpl().create("abc");
        Truth.assertThat(rootScope.authToken().getAccessToken()).isEqualTo("abc");
    }

}