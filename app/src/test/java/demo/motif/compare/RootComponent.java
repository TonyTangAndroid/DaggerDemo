package demo.motif.compare;

import demo.common.RootController;
import demo.common.RootView;
import demo.common.ViewGroup;
import motif.Expose;

@motif.Scope
public interface RootComponent {

    RootController rootController();

    LoggedInComponent build();

    @motif.Objects
    abstract class Objects {
        abstract RootController controller();

        @Expose
        RootView view(ViewGroup viewGroup) {
            return RootView.create(viewGroup);
        }
    }
}