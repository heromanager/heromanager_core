package org.darkware.hero.item.model;

import org.darkware.hero.base.ObjectFilter;
import org.darkware.hero.item.ItemSlot;
import org.darkware.hero.item.material.Material;
import org.darkware.hero.item.materialtype.MaterialType;

/**
 * @author jeff
 * @since 2015-09-14
 */
public class ItemSlotModelFilter implements ObjectFilter<Model>
{
    private final ItemSlot slot;

    public ItemSlotModelFilter(ItemSlot slot)
    {
        super();

        this.slot = slot;
    }

    /**
     * Check to see if this model is allowed by the filter.
     *
     * @param model The model to check.
     * @return <code>true</code> if the model doesn't conflict with the filter, <code>false</code>
     * if it does.
     */
    @Override public boolean allow(Model model)
    {
        return !model.getSlot().equals(this.slot);
    }
}
