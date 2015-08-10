package org.darkware.hero.damage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * @author ${user}
 * @since 2015-08-04
 */
public class Damage
{
    private final int[] damages;
    private final double[] amplifiers;

    public Damage()
    {
        super();

        this.damages = new int[DamageType.count];
        Arrays.fill(this.damages, 0);
        this.amplifiers = new double[DamageType.count];
        Arrays.fill(this.amplifiers, 1.0);
    }

    public void add(DamageType type, int amount)
    {
        this.damages[type.ordinal()] += amount;
    }

    public void add(Damage dmg)
    {
        for (DamageType type : DamageType.values())
        {
            this.add(type, dmg.damages[type.ordinal()]);
            this.amplify(type, dmg.amplifiers[type.ordinal()]);
        }
    }

    public void amplify(DamageType type, double factor)
    {
        this.amplifiers[type.ordinal()] *= factor;
    }

    public double get(DamageType type)
    {
        int dmg = this.damages[type.ordinal()];
        double amp = this.amplifiers[type.ordinal()];

        return dmg * amp;
    }
}
