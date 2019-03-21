package di.motif.example;

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

    @Test
    public void childControllerNotEquals() {

        MainScope mainScope = new MainScopeImpl();
        ChildController controller1 = mainScope.child().controller();
        ChildController controller2 = mainScope.child().controller();
        Truth.assertThat(controller1).isNotEqualTo(controller2);
    }

    @Test
    public void childControllerDatabaseEquals() {

        MainScope mainScope = new MainScopeImpl();
        Database database1 = mainScope.child().controller().getDatabase();
        Database database2 = mainScope.child().controller().getDatabase();
        Truth.assertThat(database1).isEqualTo(database2);
    }


    @Test
    public void childControllerViewNotEquals() {

        MainScope mainScope = new MainScopeImpl();
        ChildView childView1 = mainScope.child().controller().getView();
        ChildView childView2 = mainScope.child().controller().getView();
        Truth.assertThat(childView1).isNotEqualTo(childView2);
    }


    @Test
    public void childController() {

        MainScope mainScope = new MainScopeImpl();
        ChildScope childScope = mainScope.child();
        ChildController controller = childScope.controller();
        Truth.assertThat(controller).isNotNull();
    }

    @Test
    public void childControllerChildView() {

        MainScope mainScope = new MainScopeImpl();
        ChildScope childScope = mainScope.child();
        ChildController controller = childScope.controller();
        ChildView childView = controller.getView();
        Truth.assertThat(childView).isNotNull();
    }


    @Test
    public void childControllerDatabase() {

        MainScope mainScope = new MainScopeImpl();
        ChildScope childScope = mainScope.child();
        ChildController controller = childScope.controller();
        Database database = controller.getDatabase();
        Truth.assertThat(database).isNotNull();
    }


}