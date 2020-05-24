package com.gildedrose;

class GildedRose {
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE = "Aged Brie";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            countSellIn(item);
            countQuality(item);
        }
    }

    private void countQuality(Item item) {
        if (item.name.equals(BACKSTAGE_PASSES)) {
            countBackPassQuality(item);
        } else if (item.name.equals(AGED_BRIE)) {
            countAgedBrieQuality(item);
        } else if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            countSalfurasQuality();
        } else {
            countCommonItemQuality(item);
        }
    }

    private void countSalfurasQuality() {
        // Sulfuras, Hand of Ragnaros empty method
    }

    private void countCommonItemQuality(Item item) {
        if (item.quality > 0) {
            decrQuality(item, 1);
            if (item.sellIn < 0) {
                decrQuality(item, 1);
            }
        }
    }

    private void countAgedBrieQuality(Item item) {
        if (item.quality < 50) {
            incrQuality(item, 1);
        }
        if (item.sellIn < 0 && item.quality < 50) {
            incrQuality(item, 1);
        }
    }

    private void countBackPassQuality(Item item) {
        if (item.quality < 50) {
            incrQuality(item, 1);
        }
        if (item.sellIn < 11) {
            if (item.quality < 50) {
                incrQuality(item, 1);
            }
        }
        if (item.sellIn < 6) {
            if (item.quality < 50) {
                incrQuality(item, 1);
            }
        }
        if (item.sellIn < 0) {
            decrQuality(item, item.quality);
        }
    }

    private void incrQuality(Item item, int offSet) {
        item.quality = item.quality + offSet;
    }

    private void decrQuality(Item item, int offSet) {
        item.quality = item.quality - offSet;
    }

    private void countSellIn(Item item) {
        if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            item.sellIn = item.sellIn - 1;
        }
    }
}