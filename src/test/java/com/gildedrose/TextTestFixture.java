package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackStagePass;
import com.gildedrose.items.NorMalItem;
import com.gildedrose.items.Sulfuras;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TextTestFixture {
    public static void main(String[] args) {
        String baseLine = getBaseLine();

        System.out.println(baseLine);
    }

    public static String getBaseLine() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        printStream.println("OMGHAI!");

        Item[] items = new Item[]{
                new NorMalItem("+5 Dexterity Vest", 10, 20), //
                new AgedBrie(2, 0), //
                new NorMalItem("Elixir of the Mongoose", 5, 7), //
                new Sulfuras(0, 80), //
                new Sulfuras(-1, 80),
                new BackStagePass(15, 20),
                new BackStagePass(10, 49),
                new BackStagePass(5, 49),
                new BackStagePass(1, 20),
                // this conjured item does not work properly yet
                new NorMalItem("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        int days = 3;

        for (int i = 0; i < days; i++) {
            printStream.println("-------- day " + i + " --------");
            printStream.println("name, sellIn, quality");
            for (Item item : items) {
                printStream.println(item);
            }
            printStream.println();
            app.updateQuality();
        }
        return out.toString();
    }

}
