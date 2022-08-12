package util;

import java.net.HttpURLConnection;
import java.net.URL;

public class TestUtil {

    public static final long PAGE_LOAD_TIMEOUT = 20;
    public static final long IMPLICITE_WAIT = 20;

    public static void checkBrokenLink(String linkUrl){
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode() >=400){
                System.out.println(linkUrl + "-----" + httpURLConnection.getResponseMessage() + " is a broken link");
            }else {
                System.out.println(linkUrl + "-----" + httpURLConnection.getResponseMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
