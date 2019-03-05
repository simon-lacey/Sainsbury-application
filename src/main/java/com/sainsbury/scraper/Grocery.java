package com.sainsbury.scraper;

import org.json.simple.JSONObject;

/**
 * A simple class to hold information the web scraper needs about each product
 * and creates the jSON object from this information.
 * 
 * @author Simon Lacey
 */
public class Grocery {
    private String title;
    private float kCal;
    private double unitPrice;
    private String description;

    public Grocery(String title, float kCal, double unitPrice, String description) {
        this.title = title;
        this.kCal = kCal;
        this.unitPrice = unitPrice;
        this.description = description;
    }
    

    public JSONObject toJSON() {
        JSONObject ret = new JSONObject();
        ret.put("title", title);
        if (kCal > 0) {
            ret.put("kcal_per_100g", kCal);
        }
        ret.put("unit_price", unitPrice);
        ret.put("description", description);
        
        return ret;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getKCal() {
        return kCal;
    }

    public void setKCal(float kCal) {
        this.kCal = kCal;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Grocery{" + "title=" + title + ", kCal=" + kCal + ", unitPrice=" + unitPrice + ", description=" + description + '}';
    }
    
}
