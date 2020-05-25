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

    @Override
    protected boolean isBackStagePass() {
        return true;
    }
}
