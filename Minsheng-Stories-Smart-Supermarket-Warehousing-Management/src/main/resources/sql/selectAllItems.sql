SELECT itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier FROM storehouse.drinksTable
union
select itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier from storehouse.biscuitsTable
union
select itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier from storehouse.puffedFoodsTable
union
select itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier from storehouse.protectiveGearsTable
union
select itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier from storehouse.instantFoodsTable
;