package spritecn.github.bytool.requestslib;

import net.dongliu.commons.collection.Lists;
import net.dongliu.commons.collection.Maps;
import spritecn.github.bytool.requestslib.executor.SessionContext;

import java.util.*;

public class SessionRequest {
    private final SessionContext context;

    private final Map<String,Object>  headers;

    public SessionRequest(SessionContext sessionContext) {
        this.context = sessionContext;
        this.headers = Maps.of();
    }

    public SessionRequest(SessionContext sessionContext,Map<String,Object> headers) {
        this.context = sessionContext;
        this.headers = headers;
    }


    public  RequestBuilder get(String url) {
        return newRequest(Methods.GET, url);
    }

    public  RequestBuilder post(String url) {
        return newRequest(Methods.POST, url);
    }

    public  RequestBuilder put(String url) {
        return newRequest(Methods.PUT, url);
    }

    public  RequestBuilder delete(String url) {
        return newRequest(Methods.DELETE, url);
    }

    public  RequestBuilder head(String url) {
        return newRequest(Methods.HEAD, url);
    }

    public  RequestBuilder patch(String url) {
        return newRequest(Methods.PATCH, url);
    }



    /**
     * Create new request with method and url
     */
    public  RequestBuilder newRequest(String method, String url) {
        return new RequestBuilder().sessionContext(context).headers(headers).url(url).method(method);
    }

    /**
     * Return all cookies this session current hold.
     */
    public List<Cookie> currentCookies() {
        if(Objects.nonNull(context)) {
            return context.cookieJar().getCookies();
        }
        return new ArrayList<>();
    }
}
