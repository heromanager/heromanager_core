package org.darkware.hero.item.material;

import org.darkware.hero.item.materialtype.MaterialType;

/**
 * @author jeff
 * @since 2015-09-02
 */
public class MaterialBuilder
{
    public static MaterialBuilder create(String id, String name)
    {
        final MaterialBuilder builder = new MaterialBuilder(id, name);

        return builder;
    }

    private final String id;
    private final String name;

    private MaterialType type;
    private int rarity;
    private double density;
    private double hardness;
    private double value;

    private MaterialBuilder(String id, String name)
    {
        super();

        this.id = id;
        this.name = name;
    }

    public Material build()
    {
        return new Material(id, name, type, rarity, density, hardness, value);
    }

    public MaterialBuilder setType(final MaterialType type)
    {
        this.type = type;

        return this;
    }

    public MaterialBuilder setRarity(final int rarity)
    {
        this.rarity = rarity;

        return this;
    }

    public MaterialBuilder setDensity(final double density)
    {
        this.density = density;

        return this;
    }

    public MaterialBuilder setHardness(final double hardness)
    {
        this.hardness = hardness;

        return this;
    }

    public MaterialBuilder setValue(final double value)
    {
        this.value = value;

        return this;
    }
}
