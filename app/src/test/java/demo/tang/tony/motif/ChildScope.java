package demo.tang.tony.motif;


@motif.Scope
interface ChildScope {

    GrandchildScope grandchildScope();

    ChildController controller();

    @motif.Objects
    abstract class Objects {

        @motif.Expose
        abstract ChildView view();

        abstract ChildController controller();
    }
}