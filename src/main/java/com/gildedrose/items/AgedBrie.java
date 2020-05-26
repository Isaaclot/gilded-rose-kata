package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * @author liangqian@vvic.com
 * @version 1.0
 * @since 2020/5/26
 */
public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    protected void updateQuality() {
        if (quality < 50) {
            incrQuality(1);
        }
        if (sellIn < 0 && quality < 50) {
            incrQuality(1);
        }
    }
}
