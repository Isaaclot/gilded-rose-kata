package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * @author liangqian@vvic.com
 * @version 1.0
 * @since 2020/5/26
 */
public class Sulfuras extends Item {
    public Sulfuras(int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    protected void countSellIn() {

    }

    protected void updateQuality() {
        // Sulfuras, Hand of Ragnaros empty method
    }
}
