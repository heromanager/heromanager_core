package org.darkware.hero.item.material;

import org.darkware.hero.base.NamedStaticObject;
import org.darkware.hero.base.Rarified;
import org.darkware.hero.base.StaticId;
import org.darkware.hero.item.materialtype.MaterialType;

/**
 * @author jeff
 * @since 2015-09-01
 */
public class Material extends NamedStaticObject implements Rarified
{
    private final MaterialType type;
    private final int rarity;
    private final double density;
    private final double hardness;
    private final double value;

    public Material(String id, String name, MaterialType type, int rarity, double density, double hardness, double value)
    {
        super(new StaticId(id), name);

        this.type = type;
        this.rarity = rarity;
        this.density = density;
        this.hardness = hardness;
        this.value = value;
    }

    public final double getDensity()
    {
        return density;
    }

    public final double getHardness()
    {
        return hardness;
    }

    public final double getValue()
    {
        return value;
    }

    public MaterialType getType()
    {
        return type;
    }

    @Override public int getRarity()
    {
        return rarity;
    }
}
