package demo.dagger.raw;

import com.google.common.truth.Truth;

import org.junit.Test;

import demo.common.RootController;
import demo.common.ViewGroup;

public class ControllerTest {

    @Test
    public void rootControllerTest() {
        RootComponent rootComponent = DaggerRootComponent.builder().viewGroup(new ViewGroup()).build();
        RootController controller1 = rootComponent.rootController();
        RootController controller2 = rootComponent.rootController();
        Truth.assertThat(controller1).isEqualTo(controller2);
    }

    @Test
    public void bugControllerTest() {
        RootComponent rootComponent = DaggerRootComponent.builder().viewGroup(new ViewGroup()).build();
        BugController controller1 = rootComponent.bugController();
        BugController controller2 = rootComponent.bugController();
        Truth.assertThat(controller1).isNotEqualTo(controller2);
    }
}
