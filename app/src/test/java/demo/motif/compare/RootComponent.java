package demo.motif.compare;

import demo.common.RootController;
import demo.common.RootView;
import demo.common.ViewGroup;

@motif.Scope
public interface RootComponent {

    RootController rootController();

//    LoggedInScope loggedIn(ViewGroup parentViewGroup);

    @motif.Objects
    abstract class Objects {
        abstract RootController controller();

        RootView view(ViewGroup viewGroup) {
            return RootView.create(viewGroup);
        }
    }
}