package spritecn.github.bytool.requestslib.executor;

import  spritecn.github.bytool.requestslib.Interceptor;
import  spritecn.github.bytool.requestslib.RawResponse;
import  spritecn.github.bytool.requestslib.Request;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Http executor
 *
 * @author Liu Dong
 */
public interface HttpExecutor extends Interceptor.InvocationTarget {
    /**
     * Process the request, and return response
     */
    @NonNull
    RawResponse proceed(Request request);
}
