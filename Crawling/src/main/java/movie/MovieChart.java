package movie;

import dto.MovieDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieChart {

    public static List<MovieDto> getCGVdata() throws Exception {

        Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/?lt=1&ft=0").get();

        Elements titles = doc.select("div.box-contents strong.title");

        Elements percents = doc.select("div.box-contents div.score strong.percent span");

        List<MovieDto> list = new ArrayList<>();

        for (int i=0;i<19;i++) {
            Element title = titles.get(i);
            Element percent = percents.get(i);

            String t = title.text();
            double p = Double.parseDouble(percent.text().replace("%", ""));

            list.add(new MovieDto(t, p));
        }

        return list;
    }
}
