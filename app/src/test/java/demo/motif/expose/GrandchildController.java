package demo.motif.expose;

public class GrandchildController {


    private String childId;

    public GrandchildController(String childId) {
        this.childId = childId;
    }

    public String request() {
        return childId;
    }
}
