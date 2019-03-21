package demo.dagger.raw;

import com.google.common.truth.Truth;

import org.junit.Test;

import demo.common.RootView;
import demo.common.ViewGroup;

public class LoginTest {

    @Test
    public void loggedInComponentTest() {
        RootComponent rootComponent = DaggerRootComponent.builder().viewGroup(new ViewGroup()).build();
        LoggedInComponent.Builder builder = rootComponent.loggedIn();
        LoggedInComponent loggedInComponent1 = builder.build();
        LoggedInComponent loggedInComponent2 = builder.build();
        Truth.assertThat(loggedInComponent1).isNotEqualTo(loggedInComponent2);
    }

    @Test
    public void loggedInComponentChildView() {
        RootComponent rootComponent = DaggerRootComponent.builder().viewGroup(new ViewGroup()).build();
        LoggedInComponent.Builder builder = rootComponent.loggedIn();
        LoggedInComponent loggedInComponent1 = builder.build();
        LoggedInComponent loggedInComponent2 = builder.build();
        Truth.assertThat(loggedInComponent1.childView()).isNotEqualTo(loggedInComponent2.childView());
    }

    @Test
    public void loggedInComponentRootViewEqual() {
        RootComponent rootComponent = DaggerRootComponent.builder().viewGroup(new ViewGroup()).build();
        LoggedInComponent.Builder builder = rootComponent.loggedIn();
        LoggedInComponent loggedInComponent1 = builder.build();
        LoggedInComponent loggedInComponent2 = builder.build();

        RootView rootView = loggedInComponent1.childView().getRootView();
        RootView rootView1 = loggedInComponent2.childView().getRootView();
        Truth.assertThat(rootView).isEqualTo(rootView1);
    }

}
