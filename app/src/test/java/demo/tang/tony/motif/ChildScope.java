package demo.tang.tony.motif;


@motif.Scope
interface ChildScope {

    ChildController controller();

    @motif.Objects
    abstract class Objects {

        // No Database factory method. Child Controller receives the Database defined by MainScope.
        abstract ChildView view();

        abstract ChildController controller();
    }
}