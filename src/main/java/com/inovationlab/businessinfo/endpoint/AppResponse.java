package com.inovationlab.businessinfo.endpoint;

public class AppResponse {
    private int code;
    private String message;

    public AppResponse() {
    }

    public AppResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    static AppResponse getUnauthrizedResponse(){
        return new AppResponse(401, "Unauthrized");
    }
}
