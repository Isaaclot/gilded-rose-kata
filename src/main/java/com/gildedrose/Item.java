package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public static Item createBackStagePass(int sellIn, int quality) {
        return new Item(ItemType.BACKSTAGE_PASSES, sellIn, quality);
    }

    public static Item createAgedBrie(int sellIn, int quality) {
        return new Item(ItemType.AGED_BRIE, sellIn, quality);
    }

    public static Item createSulfuras(int sellIn, int quality) {
        return new Item(ItemType.SULFURAS_HAND_OF_RAGNAROS, sellIn, quality);
    }

    public static Item create(String name,int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }


    private Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void countSellIn() {
        if (!name.equals(ItemType.SULFURAS_HAND_OF_RAGNAROS)) {
            sellIn = sellIn - 1;
        }
    }

    public void countQuality() {
        if (isBackStagePass()) {
            countBackPassQuality();
        } else if (name.equals(ItemType.AGED_BRIE)) {
            countAgedBrieQuality();
        } else if (name.equals(ItemType.SULFURAS_HAND_OF_RAGNAROS)) {
            countSalfurasQuality();
        } else {
            countCommonItemQuality();
        }
    }

    private boolean isBackStagePass() {
        return name.equals(ItemType.BACKSTAGE_PASSES);
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
