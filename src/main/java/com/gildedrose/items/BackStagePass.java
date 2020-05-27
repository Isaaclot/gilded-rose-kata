package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * @author liangqian@vvic.com
 * @version 1.0
 * @since 2020/5/26
 */
public class BackStagePass extends Item {
    public BackStagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    protected void updateQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
        if (sellIn < 11) {
            if (quality < 50) {
                quality = quality + 1;
            }
        }
        if (sellIn < 6) {
            if (quality < 50) {
                quality = quality + 1;
            }
        }
        if (sellIn < 0) {
            quality = quality - quality;
        }
    }
}
