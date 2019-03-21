package demo.tang.tony.motif;

import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Test;


public class GrantchildTest {


    @Before
    public void setup() {
    }

    @Test
    public void grandchildControllerViewNotEquals() {

        MainScope mainScope = new MainScopeImpl();
        GrandchildView grandchildView1 = mainScope.child().grandchildScope().controller().getGrandchildView();
        GrandchildView grandchildView2 = mainScope.child().grandchildScope().controller().getGrandchildView();
        Truth.assertThat(grandchildView1).isNotEqualTo(grandchildView2);
    }


    @Test
    public void grandchildControllerChildView() {

        MainScope mainScope = new MainScopeImpl();
        GrandchildScope grandchildScope = mainScope.child().grandchildScope();
        GrandchildController grandchildController = grandchildScope.controller();
        GrandchildView grandchildView = grandchildController.getGrandchildView();
        Truth.assertThat(grandchildView).isNotNull();
    }


    @Test
    public void grandchildControllerDatabase() {

        MainScope mainScope = new MainScopeImpl();
        GrandchildScope grandchildScope = mainScope.child().grandchildScope();
        GrandchildController grandchildController = grandchildScope.controller();
        Database database = grandchildController.getDatabase();
        Truth.assertThat(database).isNotNull();
    }

    @Test
    public void grandchildControllerChildViewEqual() {

        MainScope mainScope = new MainScopeImpl();
        ChildScope child = mainScope.child();

        GrandchildScope grandchildScope1 = child.grandchildScope();
        GrandchildController grandchildController1 = grandchildScope1.controller();
        ChildView childView1 = grandchildController1.getChildView();
        GrandchildView grandchildView1 = grandchildController1.getGrandchildView();
        Database database1 = grandchildController1.getDatabase();
        View view1 = grandchildController1.getView();


        GrandchildScope grandchildScope2 = child.grandchildScope();
        GrandchildController grandchildController2 = grandchildScope2.controller();
        ChildView childView2 = grandchildController2.getChildView();
        GrandchildView grandchildView2 = grandchildController2.getGrandchildView();
        Database database2 = grandchildController2.getDatabase();
        View view2 = grandchildController2.getView();


        Truth.assertThat(grandchildScope1).isNotEqualTo(grandchildScope2);
        Truth.assertThat(grandchildController1).isNotEqualTo(grandchildController2);
        Truth.assertThat(grandchildView1).isNotEqualTo(grandchildView2);

        Truth.assertThat(view1).isEqualTo(view2);
        Truth.assertThat(database1).isEqualTo(database2);
        Truth.assertThat(childView1).isEqualTo(childView2);
    }
}