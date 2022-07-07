import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/?lt=1&ft=0").get();
        /*
        * <div class="box-contents">
                        <a href="/movies/detail-view/?midx=85999">
                            <strong class="title">토르-러브 앤 썬더</strong>
                        </a>
           <div class="score">
                            <strong class="percent">예매율<span>66.2%</span></strong>
        *
        *
        * */

        Elements titles = doc.select("div.box-contents strong.title");

        Elements percents = doc.select("div.box-contents div.score strong.percent span");

        for (int i=0;i<19;i++) {
            Element title = titles.get(i);
            Element percent = percents.get(i);

            System.out.println(title.text() + " " + percent.text());
        }



    }
}
