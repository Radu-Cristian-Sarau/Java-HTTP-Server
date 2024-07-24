package com.radusarau.httpserver.http;

public class HttpRequest extends HttpMessage{

    private String method;
    private String requestTarget;
    private String httpVersion;

    HttpRequest() {
    }
}
