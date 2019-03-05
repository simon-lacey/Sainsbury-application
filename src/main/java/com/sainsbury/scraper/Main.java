package com.sainsbury.scraper;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class executes the groceries site  and provides the entry point
 * @author Simon Lacey
 */
public class Main {
    public static final void main(String[] args) {
        //URL provided for the test
        String urlStr = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/" +
                "servlet/gb/groceries/berries-cherries-currants6039.html";

        try {
            URL mainURL  = new URL(urlStr);
            SiteScraper scraper = new SiteScraper(mainURL);
            //Remove any '\' values to provide expected JSON formt
            System.out.println(scraper.findGroceries().replace("\\", ""));

        } catch (MalformedURLException mal) {
            System.out.println("URL Exception in process...");
        }
    }
}
