package org.darkware.hero.item;

import org.darkware.hero.item.material.Material;
import org.darkware.hero.item.material.MaterialDeck;
import org.darkware.hero.item.material.MaterialTypeMaterialFilter;
import org.darkware.hero.item.material.Materials;
import org.darkware.hero.item.materialtype.MaterialType;
import org.darkware.hero.item.model.ItemSlotModelFilter;
import org.darkware.hero.item.model.MaterialTypeModelFilter;
import org.darkware.hero.item.model.Model;
import org.darkware.hero.item.model.ModelDeck;

/**
 * @author jeff
 * @since 2015-09-14
 */
public class ItemTemplate
{
    private MaterialType type;
    private Material material;
    private Model model;
    private ItemSlot slot;

    private int targetRarity;
    private int targetSize;
    private int targetWeight;

    public ItemTemplate()
    {
        super();

        this.targetRarity = 0;
    }

    public Item generate()
    {
        Model model = this.getModel();
        Material material = this.getMaterial();

        return new Item(material, model);
    }

    private Model getModel()
    {
        if (this.model == null)
        {
            ModelDeck models = new ModelDeck();

            if (this.type != null) models.filter(new MaterialTypeModelFilter(this.type));
            if (this.slot != null) models.filter(new ItemSlotModelFilter(this.slot));

            if (this.targetRarity == 0) this.setModel(models.pick());
            else this.setModel(models.pick(targetRarity, targetSize, targetWeight));
        }

        return this.model;
    }

    private Material getMaterial()
    {
        if (this.material == null)
        {
            MaterialDeck materials = new MaterialDeck();

            if (this.type != null)
            {
                materials.filter(new MaterialTypeMaterialFilter(this.type));
            }

            this.setMaterial(materials.pick());
        }

        return this.material;
    }

    public MaterialType getType()
    {
        return type;
    }

    public void setType(final MaterialType type)
    {
        this.type = type;
    }

    public void setMaterial(final Material material)
    {
        this.material = material;
        this.setType(material.getType());
    }

    public void setModel(final Model model)
    {
        this.model = model;
        this.setType(model.getMaterialType());
        this.setSlot(model.getSlot());
    }

    public ItemSlot getSlot()
    {
        return slot;
    }

    public void setSlot(final ItemSlot slot)
    {
        this.slot = slot;
    }
}
