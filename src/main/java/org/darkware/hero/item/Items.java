package org.darkware.hero.item;

/**
 * @author jeff
 * @since 2015-09-01
 */
public class Items
{
    public Items()
    {
        super();
    }

    public Item generate(ItemTemplate template)
    {
        // Fill in the template


        // Generate the item
        Item item = template.generate();

        // Do some adjustments and validation

        return item;
    }
}
