package spritecn.github.bytool.requestslib.executor;

/**
 * Only for internal use
 */
class URLConnectionExecutorFactory extends RequestExecutorFactory {
    static final RequestExecutorFactory instance = new URLConnectionExecutorFactory();

    @Override
    public SessionContext newSessionContext() {
        return new SessionContext(new DefaultCookieJar());
    }

    @Override
    public HttpExecutor getHttpExecutor() {
        return new URLConnectionExecutor();
    }
}
