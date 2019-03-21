package demo.tang.tony.motif;

import com.google.common.truth.Truth;

import org.junit.Test;


public class QuestionTest {


    @Test
    public void grandchildViewDiff() {

        MainScope mainScope = new MainScopeImpl();

        GrandchildScope grandchildScope1 = mainScope.child().grandchildScope();
        GrandchildScope grandchildScope2 = mainScope.child().grandchildScope();

        Truth.assertThat(grandchildScope1).isNotEqualTo(grandchildScope2);
    }

    @Test
    public void grandchildViewSame() {

        MainScope mainScope = new MainScopeImpl();
        ChildScope childScope = mainScope.child();
        GrandchildScope grandchildScope1 = childScope.grandchildScope();
        GrandchildScope grandchildScope2 = childScope.grandchildScope();
        Truth.assertThat(grandchildScope1).isNotEqualTo(grandchildScope2);
    }


}