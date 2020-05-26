package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * @author liangqian@vvic.com
 * @version 1.0
 * @since 2020/5/26
 */
public class NormalItem extends Item {
    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected void updateQuality() {
        if (quality > 0) {
            decrQuality(1);
            if (sellIn < 0) {
                decrQuality(1);
            }
        }
    }
}
