package demo.tang.tony.motif;


@motif.Scope
interface GrandchildScope {

    GrandchildController controller();

    @motif.Objects
    abstract class Objects {

        abstract GrandchildView grandchildView();

        abstract GrandchildController controller();
    }
}