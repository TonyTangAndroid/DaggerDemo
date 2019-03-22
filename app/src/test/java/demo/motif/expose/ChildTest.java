package demo.motif.expose;

import com.google.common.truth.Truth;

import org.junit.Test;

public class ChildTest {

    @Test
    public void child_test() {

        ChildScopeImpl.Dependencies dependencies = () -> new Controller(new Request(new AuthToken("123")));
        ChildScopeImpl childScope = new ChildScopeImpl(dependencies);
        Truth.assertThat(childScope.controller().request()).isEqualTo("123:success");

    }



}