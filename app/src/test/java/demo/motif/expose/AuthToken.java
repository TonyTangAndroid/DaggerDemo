package demo.motif.expose;

public class AuthToken {

    private final String accessToken;

    public AuthToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
