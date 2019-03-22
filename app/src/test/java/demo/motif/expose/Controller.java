package demo.motif.expose;

import motif.Scope;

public class Controller {


    private String childId;
    private Request request;

    public Controller(String childId, Request request) {
        this.childId = childId;
        this.request = request;
    }

    public String request() {
        return childId + ":" + request.execute();
    }
}
