package com.gildedrose

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GildedRoseTest extends AnyFlatSpec with Matchers {
  val items = Array[Item](
    new Item("+5 Dexterity Vest", 10, 20),
    new Item("Aged Brie", 2, 0),
    new Item("Elixir of the Mongoose", 5, 7),
    new Item("Sulfuras, Hand of Ragnaros", 0, 80),
    new Item("Sulfuras, Hand of Ragnaros", -1, 80),
    new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
    new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
    new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
    // this conjured item does not work properly yet
    new Item("Conjured Mana Cake", 3, 6)
  )

//  it should "do the same" ignore {
//    val items2 = items.map(i => new Item(i.name, i.sellIn, i.quality))
//    val app    = new GildedRose(items)
//    val app2   = new GildedRose2(items2)
//    app.updateQuality()
//    app2.updateQuality()
//    app.items.map(i => (i.name, i.quality, i.sellIn)) shouldBe app2.items.map(i => (i.name, i.quality, i.sellIn))
//  }

  it should "2" in {
    val items = Array[Item](new Item("Aged Brie", 2, 5))
    val app   = new GildedRose2(items)
    app.updateQuality()
    app.items(0).quality should equal(6)
  }
  it should "3" in {
    val items = Array[Item](new Item("Aged Brie", 2, 50))
    val app   = new GildedRose2(items)
    app.updateQuality()
    app.items(0).quality should equal(50)
  }
  it should "4" in {
    val items = Array[Item](new Item("Sulfuras, Hand of Ragnaros", 2, 80))
    val app   = new GildedRose2(items)
    app.updateQuality()
    app.items(0).quality should equal(80)
  }
  it should "4.1" in {
    val items = Array[Item](new Item("Sulfuras, Hand of Ragnaros", 2, 80))
    val app   = new GildedRose2(items)
    app.updateQuality()
    app.items(0).sellIn should equal(2)
  }
  it should "5" in {
    val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10))
    val app   = new GildedRose2(items)
    app.updateQuality()
    app.items(0).quality should equal(11)
  }
  it should "6" in {
    val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10))
    val app   = new GildedRose2(items)
    app.updateQuality()
    app.items(0).quality should equal(12)
  }
  it should "7" in {
    val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10))
    val app   = new GildedRose2(items)
    app.updateQuality()
    app.items(0).quality should equal(13)
  }
  it should "8" in {
    val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10))
    val app   = new GildedRose2(items)
    app.updateQuality()
    app.items(0).quality should equal(0)
  }
  it should "9" in {
    val items = Array[Item](new Item("Random", -5, 0))
    val app   = new GildedRose2(items)
    app.updateQuality()
    app.items(0).quality should equal(0)
  }
  it should "10" in {
    val items = Array[Item](new Item("Conjured Mana Cake", 10, 10))
    val app   = new GildedRose2(items)
    app.updateQuality()
    app.items(0).quality should equal(8)
  }
  it should "11" in {
    val items = Array[Item](new Item("Conjured Mana Cake", 0, 10))
    val app   = new GildedRose2(items)
    app.updateQuality()
    app.items(0).quality should equal(6)
  }
  it should "12" in {
    val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48))
    val app   = new GildedRose2(items)
    app.updateQuality()
    app.items(0).quality should equal(50)
  }
  it should "13" in {
    val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 10, 48))
    val app   = new GildedRose2(items)
    app.updateQuality()
    app.items(0).quality should equal(50)
  }
}
