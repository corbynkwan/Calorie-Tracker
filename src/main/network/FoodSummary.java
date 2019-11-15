package network;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class FoodSummary {
    //Using jsoup to make life easier for myself
    public String fetchFirstParagraph(String article) throws IOException {
        String url = "https://en.wikipedia.org/wiki/Chicken_as_food";
        Document doc = Jsoup.connect(url).get();
        Elements paragraphs =  doc.select(".mw-content-ltr p"); //Goes to the css document labelled the String <<
        Element firstParagraph = paragraphs.get(1); //Gets the first paragraph
        return firstParagraph.text();
    }
}