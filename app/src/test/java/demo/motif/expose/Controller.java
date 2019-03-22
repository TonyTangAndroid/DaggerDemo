package demo.motif.expose;

import motif.Scope;

public class Controller {


    private Request request;

    public Controller(Request request) {

        this.request = request;
    }

    public String request() {
      return   request.execute();
    }
}
