package demo.motif.expose;

import motif.Expose;
import motif.Scope;

@Scope
public interface ChildScope {

    Controller controller();

    @motif.Objects
    abstract class Objects {

        @Expose
        abstract Controller controller();
    }
}
