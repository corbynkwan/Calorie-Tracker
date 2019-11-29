package network;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class FoodSummary {

    //Returns a String containing the summary of a food item from Google.
    public String fetchSummary(String nameOfFood) throws IOException {
        String url = "https://www.google.com/search?q=" + nameOfFood;
        Document doc = Jsoup.connect(url).get();
        Elements paragraphs =  doc.select("div.kno-rdesc"); //Goes to the css document labelled the String <<
        Element firstParagraph = paragraphs.get(0); //Gets the first paragraph
        String s = firstParagraph.text();

        return s.substring(11); //To avoid the "Summary" keyword at the start of every summary paragraph
    }
}