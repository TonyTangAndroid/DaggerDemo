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


    @Test
    public void child() {

        MainScope mainScope = new MainScopeImpl();
        ChildScope childScope1 = mainScope.child();
        ChildScope childScope2 = mainScope.child();
        Truth.assertThat(childScope1).isNotNull();
        Truth.assertThat(childScope2).isNotNull();
    }


    @Test
    public void controller_equals() {

        MainScopeImpl mainScope = new MainScopeImpl();
        Controller controller1 = mainScope.controller();
        Controller controller2 = mainScope.controller();
        Truth.assertThat(controller1).isEqualTo(controller2);
    }

    @Test
    public void childNotEquals() {

        MainScope mainScope = new MainScopeImpl();
        ChildScope childScope1 = mainScope.child();
        ChildScope childScope2 = mainScope.child();
        Truth.assertThat(childScope1).isNotEqualTo(childScope2);
    }


}