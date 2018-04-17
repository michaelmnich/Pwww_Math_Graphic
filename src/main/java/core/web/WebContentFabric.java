package  main.java.core.web;

import  main.java.core.Comon.Bitmap;
import  main.java.core.Math.ShapeType;
import  main.java.core.Math.Shapes.Circle;

import java.util.Map;

/**
 * Created by Michal on 2018-04-07.
 */
public class WebContentFabric {
    /**
     * Ta matoda ma zwracać html z rysunkiem opartym o canvas
     * Dodałem przykład jak to ma wyglądać mniej więcej
     * @param map
     * @return
     */
    static private String _bitmapToHtml(Bitmap map){
        String cosntent ="<html>\n" + //przykladowy content
        "<body>\n" +
        "\n" +
        "<canvas id=\"myCanvas\" width=\""+map.GetSize()+"\" height=\"\"+map.GetSize()+\"\" style=\"border:1px solid #d3d3d3;\">\n" +
        "Your browser does not support the HTML5 canvas tag.</canvas>\n" +
        "\n" +
        "<script>\n" +
        "var c = document.getElementById(\"myCanvas\");\n" +
        "var ctx = c.getContext(\"2d\");\n" +
        "ctx.moveTo(0,0);\n" + //trick na zamalowanie pixela rysujemy kreske dlugosci 1
        "ctx.lineTo(1,0);\n" +
        "ctx.stroke();\n" +
        "</script>\n" +
        "\n" +
        "</body>\n" +
        "</html>\n";


        return cosntent;
    }

    /**
     * Ta metoda jest dość dzurawa trzeba ladnie dopisać testy oraz zabezpieczyć ją
     * @param qery
     * @return
     */
    static String ReturnContent(Map<String, String> qery ){
        String DefoultReturn = "<html><center><img src='https://techcrunch.com/wp-content/uploads/2016/05/androiddev101.jpg'></center></html>";
        if(qery.containsKey(QeryType.DRAWING.name())){
            if(qery.containsKey(ShapeType.CIRCLE.name())){
                Circle circle = null; //zrpbic nowe kolko
                return _bitmapToHtml(circle.DrawMe());
            }
            else if(qery.containsKey(ShapeType.RECTANGLE.name())){
                //dokonczyc
            }
            else if(qery.containsKey(ShapeType.TRIANGLE.name())){
                //dokonczyc
            }
        }
        else if(qery.containsKey(QeryType.MATRIX.name())){
                //dla macierzy trzeba to rozwiniąc o dodatkowe iffy zgodne z szablonem opisanym w "IMatrixMath" oraz IMatrix
                //
        }
        return DefoultReturn;
    }
}
