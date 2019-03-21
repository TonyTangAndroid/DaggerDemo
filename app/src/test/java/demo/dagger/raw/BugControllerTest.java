package demo.dagger.raw;

import com.google.common.truth.Truth;

import org.junit.Test;

import demo.common.ViewGroup;

public class BugControllerTest {

    @Test
    public void bugControllerTest() {
        RootComponent rootComponent = DaggerRootComponent.builder().viewGroup(new ViewGroup()).build();
        BugController controller1 = rootComponent.bugController();
        BugController controller2 = rootComponent.bugController();
        Truth.assertThat(controller1).isNotEqualTo(controller2);
    }
}
