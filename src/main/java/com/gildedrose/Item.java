package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    protected Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    protected void countSellIn() {
        sellIn = sellIn - 1;
    }

    protected void updateQuality() {
    }

    public void incrQuality(int offSet) {
        quality = quality + offSet;
    }

    public void decrQuality(int offSet) {
        quality = quality - offSet;
    }

    public void passOneDay() {
        countSellIn();
        updateQuality();
    }

}
