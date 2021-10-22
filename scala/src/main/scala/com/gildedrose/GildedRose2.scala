package com.gildedrose

class GildedRose2(val items: Array[Item]) {

  def updateQuality(): Unit =
    for (item <- items) {
      handleQuality(item)
      handleSellIn(item)
      handleOutOfDate(item)
    }

  private def handleOutOfDate(item: Item): Unit =
    if (item.sellIn < 0) {
      if (isAgedBrie(item)) increaseQualityBy1(item)
      else if (isBackstagePasses(item)) item.quality = 0
      else {
        if (isConjured(item)) decreaseQualityBy1(item)
        decreaseQualityBy1(item)
      }
    }

  private def isConjured(item: Item) =
    item.name == "Conjured Mana Cake"

  private def handleSellIn(item: Item) =
    if (isNotSulfuras(item)) item.sellIn = item.sellIn - 1

  private def hasMaxQuality(item: Item) =
    item.quality >= 50

  private def isAgedBrie(item: Item) =
    item.name == "Aged Brie"

  private def isBackstagePasses(item: Item) =
    item.name == "Backstage passes to a TAFKAL80ETC concert"

  private def hasQuality(item: Item) =
    item.quality > 0

  private def isNotSulfuras(item: Item) =
    item.name != "Sulfuras, Hand of Ragnaros"

  private def handleQuality(item: Item): Unit = {
    handleIncreaseQuality(item)
    handleDecreaseQuality(item)
  }

  private def decreaseQualityBy1(item: Item): Unit =
    if (hasQuality(item) && isNotSulfuras(item) && !isAgedBrie(item) && !isBackstagePasses(item))
      item.quality = item.quality - 1

  private def increaseQualityBy1(item: Item): Unit =
    if (!hasMaxQuality(item) && isNotSulfuras(item) && (isAgedBrie(item) || isBackstagePasses(item)))
      item.quality = item.quality + 1

  private def handleIncreaseQuality(item: Item): Unit = {
    if (isAgedBrie(item)) increaseQualityBy1(item)
    if (isBackstagePasses(item)) {
      increaseQualityBy1(item)
      if (item.sellIn < 6) {
        increaseQualityBy1(item)
        increaseQualityBy1(item)
      } else if (item.sellIn < 11)
        increaseQualityBy1(item)
    }
  }

  private def handleDecreaseQuality(item: Item): Unit = {
    decreaseQualityBy1(item)
    if (isConjured(item)) decreaseQualityBy1(item)
  }

}
