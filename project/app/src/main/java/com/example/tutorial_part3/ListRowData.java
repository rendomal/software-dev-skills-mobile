package com.example.tutorial_part3;

public class ListRowData {

    private String[] names;
    private String[] prices;
    private String[] descriptions;

    private String[] whiteBelly;

    private int[] imageIds;



    public ListRowData(String[] names, String[] prices, String[] descriptions, String[] whiteBelly, int[] imageIds) {
        this.names = names;
        this.prices = prices;
        this.descriptions = descriptions;
        this.whiteBelly = whiteBelly;
        this.imageIds = imageIds;
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

    public String[] getWhiteBelly() {
        return whiteBelly;
    }

    public int[] getImageIds() {
        return imageIds;
    }
    public int getCount() {
        return names.length;
    }
}

