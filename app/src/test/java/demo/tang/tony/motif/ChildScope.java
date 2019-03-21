package demo.tang.tony.motif;


@motif.Scope
interface ChildScope {

    ChildController controller();

    @motif.Objects
    class Objects {

        // No Database factory method. Child Controller receives the Database defined by MainScope.
        ChildView view() {
            return new ChildView();
        }

        ChildController controller(Database database, ChildView view) {
            return new ChildController(database, view);
        }
    }
}