package org.darkware.hero.damage;

import org.darkware.hero.base.EnumFactorSet;
import org.darkware.hero.base.EnumValueSet;

/**
 * @author ${user}
 * @since 2015-08-04
 */
public class Damage
{
    private final EnumValueSet<DamageType> damages;
    private final EnumFactorSet<DamageType> amplifiers;

    public Damage()
    {
        super();

        this.damages = new EnumValueSet<>(0, DamageType.class);
        this.amplifiers = new EnumFactorSet<>(1.0, DamageType.class);
    }

    public void add(DamageType type, int amount)
    {
        this.damages.add(type, amount);
    }

    public void add(Damage dmg)
    {
        for (DamageType type : DamageType.values())
        {
            this.add(type, dmg.getBase(type));
            this.amplify(type, dmg.getFactor(type));
        }
    }

    public void amplify(DamageType type, double factor)
    {
        this.amplifiers.apply(type, factor);
    }

    public int getBase(DamageType type)
    {
        return this.damages.get(type);
    }

    public double getFactor(DamageType type)
    {
        return this.amplifiers.get(type);
    }

    public double get(DamageType type)
    {
        int dmg = this.damages.get(type);
        double amp = this.getFactor(type);

        return dmg * amp;
    }
}
