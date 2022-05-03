package spritecn.github.bytool.requestslib.body;

import net.dongliu.commons.io.InputStreams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import  static spritecn.github.bytool.requestslib.HttpHeaders.CONTENT_TYPE_BINARY;

/**
 * @author Liu Dong
 * @deprecated use {@link InputStreamSupplierRequestBody} instead
 */
@Deprecated
class InputStreamRequestBody extends RequestBody<InputStream> {
    private static final long serialVersionUID = -2463504960044237751L;

    InputStreamRequestBody(InputStream body) {
        super(body, CONTENT_TYPE_BINARY, false);
    }

    @Override
    public void writeBody(OutputStream out, Charset charset) throws IOException {
        try (InputStream in = body()) {
            InputStreams.transferTo(in, out);
        }
    }
}
