package demo.motif.expose;

import motif.Expose;
import motif.Scope;

@Scope
public interface ChildScope {

    Controller controller();

    GrandchildScope create();

    @motif.Objects
    abstract class Objects {

        @Expose
        abstract Controller controller();

        @Expose
        static String childChildId() {
            return "childChildId";
        }
    }
}
