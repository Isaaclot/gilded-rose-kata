package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackStagePass;
import com.gildedrose.items.NorMalItem;
import com.gildedrose.items.Sulfuras;

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

    void countSellIn() {
        if (!isSulfuras()) {
            sellIn = sellIn - 1;
        }
    }

    protected boolean isSulfuras() {
        return false;
    }

    public void countQuality() {
        if (isBackStagePass()) {
            countBackPassQuality();
        } else if (isAgedBrie()) {
            countAgedBrieQuality();
        } else if (isSulfuras()) {
            countSalfurasQuality();
        } else {
            countCommonItemQuality();
        }
    }

    protected boolean isAgedBrie() {
        return false;
    }

    protected boolean isBackStagePass() {
        return false;
    }

    public void countCommonItemQuality() {
        if (quality > 0) {
            decrQuality(1);
            if (sellIn < 0) {
                decrQuality(1);
            }
        }
    }

    public void countAgedBrieQuality() {
        if (quality < 50) {
            incrQuality(1);
        }
        if (sellIn < 0 && quality < 50) {
            incrQuality(1);
        }
    }

    public void countBackPassQuality() {
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

    public void passOneDay() {
        countSellIn();
        countQuality();
    }
}
