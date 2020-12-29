package testAutomationSelfEducation.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

public class FluentApi {

    public String sendPostGetToken() throws IOException {
        final Collection<NameValuePair> params = new ArrayList<>();

        final Content postResultForm = Request.Post("http://localhost:8080/api/token/get?variant=4")
                .bodyForm(params, Charset.defaultCharset())
                .execute().returnContent();
        String token = postResultForm.asString();
        return token;
    }

    @Test
    public String sendPostTestId(String myProjecktName) throws IOException, URISyntaxException {

        URIBuilder ub = new URIBuilder();
        ub.setScheme("http").setHost("localhost").setPort(8080).setPath("/api/test/put").setParameter("SID", "2222").setParameter("projectName", myProjecktName).
                setParameter("testName", "testForMe").setParameter("methodName", "method").setParameter("env", "localhost");
        final Content postResultForm = Request.Post(ub.build())
                .execute().returnContent();
        String token = postResultForm.asString();
        return token;

    }
    @Test
    public void sendScreen(String id,String screen) throws URISyntaxException, IOException {
            URIBuilder ub = new URIBuilder();
            ub.setScheme("http").setHost("localhost").setPort(8080).setPath("/api/test/put/attachment").setParameter("testId", id).setParameter("content", screen).
                    setParameter("contentType", "image/png");
            final Content postResultForm = Request.Post(ub.build())
                    .execute().returnContent();
            String token = postResultForm.asString();
    }
}