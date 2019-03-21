package demo.motif.compare;

import com.google.common.truth.Truth;

import org.junit.Test;

import demo.common.RootController;
import demo.common.ViewGroup;

public class ControllerTest {

    @Test
    public void rootControllerTest() {

        RootComponent rootComponent = new RootComponentImpl(new RootComponentImpl.Dependencies() {
            @Override
            public ViewGroup viewGroup() {
                return new ViewGroup();
            }
        });

        RootController controller1 = rootComponent.rootController();
        RootController controller2 = rootComponent.rootController();
        Truth.assertThat(controller1).isEqualTo(controller2);
    }


}
