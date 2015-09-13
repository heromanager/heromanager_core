package org.darkware.hero.damage;

import org.darkware.hero.base.EnumFactorSet;

/**
 * @author jeff
 * @since 2015-09-10
 */
public class Defense extends EnumFactorSet<DamageType>
{
    public Defense()
    {
        super(1.0, DamageType.class);
    }

    @Override protected double modifyValue(final double currentValue, final double newValue)
    {
        return currentValue * (1.0 - newValue);
    }

    public Defense copy()
    {
        Defense copy = new Defense();

        this.copyTo(copy);

        return copy;
    }
}
