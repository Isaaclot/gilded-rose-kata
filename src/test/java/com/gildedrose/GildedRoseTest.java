package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[]{new Item("foo", 1, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertThat(app.items[0].quality, is(4));
        assertThat(app.items[0].sellIn, is(0));
    }

    @Test
    public void should_negative_sellIn_double_desc_quality() {
        Item[] items = new Item[]{new Item("negative_sellIn_foo", -1, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("negative_sellIn_foo", app.items[0].name);
        assertThat(app.items[0].quality, is(3));
        assertThat(app.items[0].sellIn, is(-2));
    }

    @Test
    public void should_aged_brie_incr_quality() {
        Item[] items = new Item[]{new Item("Aged Brie", 2, 6)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertThat(app.items[0].quality, is(7));
        assertThat(app.items[0].sellIn, is(1));
    }

    @Test
    public void should_item_no_negative_quality() {
        Item[] items = new Item[]{new Item("item", 2, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("item", app.items[0].name);
        assertThat(app.items[0].quality, is(0));
        assertThat(app.items[0].sellIn, is(1));
    }

    @Test
    public void should_sulfuras_no_decr_sellIn_quality() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 2, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertThat(app.items[0].quality, is(2));
        assertThat(app.items[0].sellIn, is(2));
    }

    @Test
    public void should_backstage_pass_incr_2_sellIn_quality() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 2, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertThat(app.items[0].quality, is(5));
        assertThat(app.items[0].sellIn, is(1));
    }

    @Test
    public void should_backstage_pass_incr_8_sellIn_quality() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 8, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertThat(app.items[0].quality, is(7));
        assertThat(app.items[0].sellIn, is(7));
    }

    @Test
    public void should_backstage_pass_incr_12_sellIn_quality() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 12, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertThat(app.items[0].quality, is(6));
        assertThat(app.items[0].sellIn, is(11));
    }

    @Test
    public void should_backstage_pass_0_sellIn_quality() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertThat(app.items[0].quality, is(0));
        assertThat(app.items[0].sellIn, is(-1));
    }

}
