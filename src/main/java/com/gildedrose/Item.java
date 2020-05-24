package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void countSellIn() {
        if (!name.equals(GildedRose.SULFURAS_HAND_OF_RAGNAROS)) {
            sellIn = sellIn - 1;
        }
    }

    public void countQuality(GildedRose gildedRose) {
        if (name.equals(GildedRose.BACKSTAGE_PASSES)) {
            countBackPassQuality(gildedRose);
        } else if (name.equals(GildedRose.AGED_BRIE)) {
            countAgedBrieQuality(gildedRose);
        } else if (name.equals(GildedRose.SULFURAS_HAND_OF_RAGNAROS)) {
            countSalfurasQuality();
        } else {
            countCommonItemQuality(gildedRose);
        }
    }

    public void countCommonItemQuality(GildedRose gildedRose) {
        if (quality > 0) {
            decrQuality(1);
            if (sellIn < 0) {
                decrQuality(1);
            }
        }
    }

    public void countAgedBrieQuality(GildedRose gildedRose) {
        if (quality < 50) {
            incrQuality(1);
        }
        if (sellIn < 0 && quality < 50) {
            incrQuality(1);
        }
    }

    public void countBackPassQuality(GildedRose gildedRose) {
        if (quality < 50) {
            incrQuality(1);
        }
        if (sellIn < 11) {
            if (quality < 50) {
                incrQuality(1);
            }
        }
        if (sellIn < 6) {
            if (quality < 50) {
                incrQuality(1);
            }
        }
        if (sellIn < 0) {
            decrQuality(quality);
        }
    }

    public void incrQuality(int offSet) {
        quality = quality + offSet;
    }

    public void decrQuality(int offSet) {
        quality = quality - offSet;
    }

    public static void countSalfurasQuality() {
        // Sulfuras, Hand of Ragnaros empty method
    }
}
