package core;
import com.sun.net.httpserver.HttpServer;
import core.web.MyHttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by Michal on 2018-04-07.
 */

public class main {
    public static void main(String  [] arg){
        HttpServer server = null;
        try {
            MyHttpServer myHttp =  new MyHttpServer();
            server = HttpServer.create(new InetSocketAddress(8001), 0);
            server.createContext("/", new MyHttpServer());

            server.setExecutor(null); // creates a default executor
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
