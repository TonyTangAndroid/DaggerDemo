package demo.motif.expose;

import motif.Expose;
import motif.Scope;

@Scope
public interface RootScope {

    ChildScope createChild(String childId);

    Request request();

    AuthToken authToken();

    @motif.Objects
    abstract class Objects {

        @Expose
        abstract Request request();

        abstract AuthToken authToken();

    }
}
