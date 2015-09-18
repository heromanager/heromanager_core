package org.darkware.hero.ability;

/**
 * @author jeff
 * @since 2015-09-06
 */
public class Attack
{
    private int minDamage;
    private int maxDamage;
    private DamageType baseDamageType;
    private DamageType secondaryDamageType;
    private double secondaryPortion;

    public Attack()
    {
        super();

        this.minDamage = 1;
        this.maxDamage = 1;
        this.secondaryDamageType = DamageType.NONE;
        this.secondaryPortion = 0.0;
    }

    /**
     * Makes a copy of this Attack.
     *
     * @return An Attack object containing the same functional data as this one.
     */
    public Attack copy()
    {
        Attack copy = new Attack();

        copy.setMinDamage(this.getMinDamage());
        copy.setMaxDamage(this.getMaxDamage());
        copy.setBaseDamageType(this.getBaseDamageType());

        if (this.hasSecondaryDamage())
        {
            copy.setSecondaryDamage(this.getSecondaryDamageType(), this.getSecondaryPortion());
        }
        else
        {
            copy.setSecondaryDamage(DamageType.NONE, 0.0);
        }

        return copy;
    }

    public int getMaxDamage()
    {
        return maxDamage;
    }

    public void setMaxDamage(final int maxDamage)
    {
        this.maxDamage = maxDamage;
    }

    public int getMinDamage()
    {
        return minDamage;
    }

    public void setMinDamage(final int minDamage)
    {
        this.minDamage = minDamage;
    }

    /**
     * Fetch the base damage type. This is the damage type that will be used for
     * any damage that is not otherwise defined.
     *
     * @return A {@link DamageType}.
     */
    public DamageType getBaseDamageType()
    {
        return baseDamageType;
    }

    /**
     * Checks to see if this Attack has some damage done by a secondary damage type.
     *
     * @return <code>true</code> if the attack does secondary damage, <code>false</code> if it does not.
     */
    public final boolean hasSecondaryDamage()
    {
        return this.secondaryDamageType != DamageType.NONE;
    }

    /**
     * Sets the base damage for this attack.
     *
     * @param baseDamageType The base {@link DamageType} to use.
     */
    public void setBaseDamageType(final DamageType baseDamageType)
    {
        this.baseDamageType = baseDamageType;
    }

    public DamageType getSecondaryDamageType()
    {
        return secondaryDamageType;
    }

    public void setSecondaryDamage(final DamageType secondaryDamageType, final double portion)
    {
        if (portion <= 0.0)
        {
            this.secondaryPortion = 0.0;
            this.secondaryDamageType = DamageType.NONE;
        }
        else
        {
            this.secondaryDamageType = secondaryDamageType;
            this.secondaryPortion = portion;
        }
    }

    public double getSecondaryPortion()
    {
        return secondaryPortion;
    }

    public void setSecondaryPortion(final double secondaryPortion)
    {
        this.secondaryPortion = secondaryPortion;
    }
}
