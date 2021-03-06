package spritecn.github.bytool.requestslib.executor;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * Maintain session.
 */
public class SessionContext implements Serializable {
    private static final long serialVersionUID = -2357887929783737274L;
    private final CookieJar cookieJar;

    public SessionContext(CookieJar cookieJar) {
        this.cookieJar = requireNonNull(cookieJar);
    }

    /**
     * @deprecated use {@link #cookieJar()}
     */
    @Deprecated
    public CookieJar getCookieJar() {
        return cookieJar;
    }

    public CookieJar cookieJar() {
        return cookieJar;
    }
}
