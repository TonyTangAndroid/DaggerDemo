package demo.motif.expose;

import javax.inject.Inject;

public class Request {
    private AuthToken authToken;

    public Request(AuthToken authToken) {
        this.authToken = authToken;
    }

    public String execute() {
        return authToken.getAccessToken() + ":success";
    }


}
