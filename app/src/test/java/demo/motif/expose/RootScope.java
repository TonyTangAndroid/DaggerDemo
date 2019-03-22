package demo.motif.expose;

import motif.Scope;

@Scope
public interface RootScope {

//        ChildLeftScope left();

    Request request();

    @motif.Objects
    abstract class Objects {
        abstract Request value();

        abstract AuthToken authToken();

    }
}
