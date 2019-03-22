package demo.motif.expose;

import motif.Expose;
import motif.Scope;

@Scope
public interface GrandchildScope {

    GrandchildController grandchildController();

    @motif.Objects
    abstract class Objects {

        @Expose
        abstract GrandchildController grandchildController();
    }
}
