package com.gildedrose;

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
                Item.create("+5 Dexterity Vest", 10, 20), //
                Item.createAgedBrie(2, 0), //
                Item.create("Elixir of the Mongoose", 5, 7), //
                Item.createSulfuras(0, 80), //
                Item.createSulfuras(-1, 80),
                Item.createBackStagePass(15, 20),
                Item.createBackStagePass(10, 49),
                Item.createBackStagePass(5, 49),
                Item.createBackStagePass(1, 20),
                // this conjured item does not work properly yet
                Item.create("Conjured Mana Cake", 3, 6)};

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
