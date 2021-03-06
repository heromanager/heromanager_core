package org.darkware.hero.item;

import org.darkware.hero.item.inscribe.Inscription;
import org.darkware.hero.item.material.Material;
import org.darkware.hero.item.model.Model;

/**
 * @author jeff
 * @since 2015-09-01
 */
public class Item
{
    private Material material;
    private Model model;
    private Inscription inscription;

    public Item()
    {
        super();
    }

    public Item(Material material, Model model)
    {
        this();

        this.setMaterial(material);
        this.setModel(model);
    }

    public Item(Material material, Model model, Inscription inscription)
    {
        this(material, model);

        this.setInscription(inscription);
    }

    public int getValue()
    {
        // Find the base value of the materials involved.
        double value = this.material.getValue() * this.model.getVolume();

        // Apply the model value factor
        value *= this.model.getValueFactor();

        // Apply any extra value from the inscription
        //TODO: Add value bonuses from the inscription

        return (int)value;
    }

    public double getWeight()
    {
        return this.material.getDensity() * this.model.getVolume();
    }

    public Material getMaterial()
    {
        return material;
    }

    protected void setMaterial(final Material material)
    {
        this.material = material;
    }

    public Model getModel()
    {
        return model;
    }

    protected void setModel(final Model model)
    {
        this.model = model;
    }

    public Inscription getInscription()
    {
        return inscription;
    }

    protected void setInscription(final Inscription inscription)
    {
        this.inscription = inscription;
    }

    public String getName()
    {
        return this.material.getName() + " " + this.model.getName();
    }
}
