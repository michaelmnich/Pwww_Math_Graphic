package  main.java.core.web;

/**
 * Created by Michal on 2018-04-07.
 */

import java.io.*;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


public class MyHttpServer implements HttpHandler{

        public static Map<String, String> splitQuery(String url) throws UnsupportedEncodingException {
            Map<String, String> query_pairs = new LinkedHashMap<String, String>();
            String query = url;
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                int idx = pair.indexOf("=");
                query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
            }
            return query_pairs;
        }
        @Override
        public void handle(HttpExchange t) throws IOException {
            //to nie dziala ogarnijcie dlaczego podpowiedź trzeba zrobić obsluge wyświetlania obrazków jest w sekcji /img
            String DefoultReturn = "<html><center><img src='./img/404.jpg'></center></html>";
            //podpowiedz 2 src='./img' to juz bedzie dzialać
            String response = DefoultReturn;
            String temp =  t.getRequestURI().getQuery();
            String temp2 =  t.getRequestURI().getPath();
            if(temp2.equals("/index")){
                 if(temp!=null){
                    response = WebContentFabric.ReturnContent(splitQuery(temp));
                }else{
                     //zamiast tego ma byc formularz do wykonywania reqesrów
                     //Formularz ma miec pola od kazdego reqesta mozna zrobić to jakoś łądnie oraz wysyłać dane do serwera metoda get
                     response = "<html><center><img src='https://techcrunch.com/wp-content/uploads/2016/05/androiddev101.jpg'></center></html>";

                 }
            }//test
            else if(temp2.equals("/img")){
                Headers headers = t.getResponseHeaders();
                headers.add("Content-Type", "image/png");

                File file = new File ("D:\\Workspace\\Pwww_Math_Graphic\\src\\img\\404.jpg");
                byte[] bytes  = new byte [(int)file.length()];
                System.out.println(file.getAbsolutePath());
                System.out.println("length:" + file.length());

                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                bufferedInputStream.read(bytes, 0, bytes.length);

                t.sendResponseHeaders(200, file.length());
                OutputStream outputStream = t.getResponseBody();
                outputStream.write(bytes, 0, bytes.length);
                outputStream.close();
                return;
            }
            else if(temp2.equals("/test")){
                response="<iframe src='https://giphy.com/embed/NGp9QCXJcBPuU' width='480' height='270' frameBorder='0' class='giphy-embed' allowFullScreen></iframe></p>";

            }

            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

}
