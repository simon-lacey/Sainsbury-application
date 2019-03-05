package com.sainsbury.scraper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


/**
 *
 * @author Simon Lacey
 */
public class SiteScraperTest {
    SiteScraper scraper;

    public SiteScraperTest() {
    }

    @Before
    public void setUp() {
        URL url;
        try {
            url = new URL("https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/" +
                                    "servlet/gb/groceries/berries-cherries-currants6039.html");
            scraper = new SiteScraper(url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(SiteScraperTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
        scraper = null;
    }

    @Test
    public void testfindGroceriesNotEmpty() {
        String json = scraper.findGroceries();
        assertTrue(!json.isEmpty());
    }

    @Test
    public void testFindGroceriesHasTotalAndResults() {
        String json = scraper.findGroceries();
        assertTrue(json.contains("total") && json.contains("results"));
    }

    @Test
    public void testfindGroceriesReturnsNull() {
        String adr = "http://www.google.com";
        try{
            URL mainURL  = new URL(adr);
            SiteScraper googleScraper = new SiteScraper(mainURL);
            String json = googleScraper.findGroceries();
            assertNull(json);
        } catch (MalformedURLException mal) {
            System.out.println("URL Exception in process...");
        }
    }

    @Test
    public void testScrapeReturnsProduct() {
        String json = scraper.findGroceries();
        assertTrue(json.contains("Strawberries"));
    }
}
