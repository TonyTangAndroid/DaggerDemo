package demo.tang.tony.motif;

import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Test;


public class MotifTest {


    @Before
    public void setup() {
    }

    @Test
    public void motif() {


        MainScopeImpl mainScope = new MainScopeImpl();
        Controller controller = mainScope.controller();
        Truth.assertThat(controller).isNotNull();
    }


}