package org.roommate.models;

import org.roommate.enums.ItemCategory;
import org.roommate.enums.TaxCode;

public class Item
{
    private final String name;
    private final ItemCategory itemCategory;
    private final double rawPrice;
    private final TaxCode taxCode;

    public Item(String name, ItemCategory itemCategory, double rawPrice, TaxCode taxCode)
    {
        this.name = name;
        this.itemCategory = itemCategory;
        this.rawPrice = rawPrice;
        this.taxCode = taxCode;
    }

    public String getName()
    {
        return name;
    }


    public ItemCategory getItemCategory()
    {
        return itemCategory;
    }



    public double getRawPrice()
    {
        return rawPrice;
    }


    public TaxCode getTaxCode()
    {
        return taxCode;
    }

}
