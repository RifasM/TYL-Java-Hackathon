
import java.awt.datatransfer.SystemFlavorMap;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.jsoup.Jsoup;
import java.util.Collections;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Scrape {


    public static void main(String[] args) throws FileNotFoundException {

        callWebsite();


    }

    public static void callWebsite() {

        try {/*
            Document doc = Jsoup.connect("https://in.finance.yahoo.com/").userAgent("Mozilla/5.0 (X11; Linux x86_64; rv:32.0) Gecko/20100101 Firefox/32.0")
                    .ignoreHttpErrors(true).get();
            Elements links = doc.getElementsByClass("Trsdu(0.3s) Fz(s) Mt(4px) Mb(0px) Fw(b) D(ib)");
            */String values = "";/*
            values = links.text();*/


            String[] array = new String[100];
            String[] array1 = new String[100];


            Document doc = Jsoup.connect("https://in.finance.yahoo.com/most-active").userAgent("Mozilla/5.0 (X11; Linux x86_64; rv:32.0) Gecko/20100101 Firefox/32.0")
                    .ignoreHttpErrors(true).get();

            Elements links = doc.getElementsByClass("Va(m) Ta(start) Px(10px) Fz(s)");
            Elements links1 = doc.getElementsByClass("Trsdu(0.3s) ");
            int i =0,j=0;
            for (Element e: links
                 ) {
                values = e.text();
                array[i++]=values;
                //System.out.println(values);
            }
            int count=0;
            for (Element e: links1
            ) {
                if(count%3!=0)
                    continue;
                values = e.text();
                array1[j++]=values;
                //System.out.println(values);
            }


            int polo=2;
            for(int k=0;k<array.length;k++){

                if(array[k] == null)
                    break;

                System.out.print(array[k]+"\t\t\t");

                System.out.println(array1[polo]+" "+array1[polo+1]+" "+array1[polo+2]);
                polo+=3;
            }



            /*for (Element s : links) {
                Elements n = s.select("div.inplayStatusDetails > label.ellips ").eq(1);
                System.out.println(n.text());

            }*/
        } catch (IOException ex) {
            Logger.getLogger(Scrape.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}