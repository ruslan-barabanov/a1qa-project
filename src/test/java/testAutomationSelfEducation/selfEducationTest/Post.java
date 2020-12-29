package testAutomationSelfEducation.selfEducationTest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Post {
    public Post() throws IOException {
    }
    final URL url = new URL("http://jsonplaceholder.typicode.com/posts?_limit=10");
    final HttpURLConnection con = (HttpURLConnection) url.openConnection();


}
