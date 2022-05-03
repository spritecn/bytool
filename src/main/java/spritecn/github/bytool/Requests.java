package spritecn.github.bytool;


import spritecn.github.bytool.requestslib.Methods;
import spritecn.github.bytool.requestslib.RequestBuilder;
import spritecn.github.bytool.requestslib.SessionRequest;
import spritecn.github.bytool.requestslib.executor.RequestExecutorFactory;

import java.util.*;

/**
 * Http request utils methods.
 *
 * @author Liu Dong
 */

public class Requests {

    public static RequestBuilder get(String url) {
        return newRequest(Methods.GET, url);
    }

    public static RequestBuilder post(String url) {
        return newRequest(Methods.POST, url);
    }

    public static RequestBuilder put(String url) {
        return newRequest(Methods.PUT, url);
    }

    public static RequestBuilder delete(String url) {
        return newRequest(Methods.DELETE, url);
    }

    public static RequestBuilder head(String url) {
        return newRequest(Methods.HEAD, url);
    }

    public static RequestBuilder patch(String url) {
        return newRequest(Methods.PATCH, url);
    }


    /**
     * Create new request with method and url
     */
    public static RequestBuilder newRequest(String method, String url) {
        return new RequestBuilder().method(method).url(url);
    }

    /**
     * Create new sessionRequest
     */
    public static SessionRequest buildSessionRequest() {
        RequestExecutorFactory factory = RequestExecutorFactory.getInstance();
        return new SessionRequest(factory.newSessionContext());
    }

    /**
     * Create new sessionRequest
     */
    public static SessionRequest buildSessionRequestWithHeader(Map<String,Object> headers) {
        RequestExecutorFactory factory = RequestExecutorFactory.getInstance();
        return new SessionRequest(factory.newSessionContext(),headers);
    }


}
