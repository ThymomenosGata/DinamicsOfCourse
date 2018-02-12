import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Dinamics {
    public static void wow() throws IOException {
        Document doc = Jsoup.connect("http://www.banki.ru/products/currency/usd/").get();
        Document docE = Jsoup.connect("http://www.banki.ru/products/currency/eur/").get();
        Document cry = Jsoup.connect("https://coinspot.io/currencies/view/btc").get();
        Document eth = Jsoup.connect("https://coinspot.io/currencies/view/eth").get();
        Document ltc = Jsoup.connect("https://coinspot.io/currencies/view/ltc").get();
        Elements str = doc.getElementsByClass("currency-table__darken-bg");

        System.out.println(str.text());
        char[] Dlr = str.text().toCharArray();
        String st = "";
        for(int i = 9; i<11; i++){
            st +=Dlr[i];
        }
        double db = Double.valueOf(st);
        st = "";
        for(int i = 12; i<14; i++){
            st +=Dlr[i];
        }
        db+=(Double.valueOf(st)/100);

        str = docE.getElementsByClass("currency-table__darken-bg");
        System.out.println(str.text());

        System.out.println();
        System.out.println("Курс криптовалют в доллорах:");
        str = cry.getElementsByClass("val");

        System.out.println("Курс BTC " + str.first().text());
        Dlr = str.first().text().toCharArray();
        st = "";
        for(int i = 0; i<5; i++){
            if(Dlr[i] != '.')
                st +=Dlr[i];
        }
        double bt = Double.valueOf(st);
        st = "";
        for(int i = 5; i<7; i++){
            if(Dlr[i] != '$')
                st +=Dlr[i];
        }
        bt+=(Double.valueOf(st)/100);
        bt*=db;
        str = eth.getElementsByClass("val");

        System.out.println("Курс ETH " + str.first().text());
        Dlr = str.first().text().toCharArray();
        st = "";
        for(int i = 0; i<4; i++){
            if(Dlr[i] != '.')
                st +=Dlr[i];
        }
        double et = Double.valueOf(st);
        st = "";
        for(int i = 5; i<8; i++){
            if(Dlr[i] != '$')
                st +=Dlr[i];
        }
        et+=(Double.valueOf(st)/100);
        et*=db;
        str = ltc.getElementsByClass("val");

        System.out.println("Курс LTC " + str.first().text());
        Dlr = str.first().text().toCharArray();
        st = "";
        for(int i = 0; i<4; i++){
            if(Dlr[i] != '.')
            st +=Dlr[i];
        }
        double lt = Double.valueOf(st);
        st = "";
        for(int i = 5; i<8; i++){
            if(Dlr[i] != '$')
                st +=Dlr[i];
        }
        lt+=(Double.valueOf(st)/100);
        lt*=db;

        System.out.println();
        System.out.println("Курс криптовалют в рублях:");
        System.out.println("Курс BTC " + bt + "р");
        System.out.println("Курс ETH " + et + "р");
        System.out.println("Курс LTC " + lt + "р");

    }
}
