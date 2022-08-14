package kr.kro.whytalk.api.domain;

public class Response {
    private final String message;

    public Response(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
