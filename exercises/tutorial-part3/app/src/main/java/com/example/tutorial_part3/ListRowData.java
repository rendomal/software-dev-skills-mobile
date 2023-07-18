package com.example.tutorial_part3;

public class ListRowData {

    private String[] names;
    private String[] prices;
    private String[] descriptions;

    public ListRowData(String[] names, String[] prices, String[] descriptions) {
        this.names = names;
        this.prices = prices;
        this.descriptions = descriptions;
    }

    public String[] getNames() {
        return names;
    }

    public String[] getPrices() {
        return prices;
    }

    public String[] getDescriptions() {
        return descriptions;
    }

    public int getCount() {
        return names.length;
    }
}

