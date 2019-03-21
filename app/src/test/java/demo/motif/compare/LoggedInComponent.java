package demo.motif.compare;

import demo.common.ChildView;
import motif.Scope;

@Scope
public interface LoggedInComponent {

    ChildView childView();

    @motif.Objects
    abstract class Objects {

        abstract ChildView childView();
    }
}