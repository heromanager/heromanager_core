package org.darkware.hero.damage;

/**
 * @author ${user}
 * @since 2015-08-04
 */
public enum DamageType
{
    SLASHING,
    BLUNT,
    PIERCING,

    FIRE,
    COLD,
    SHOCKING,
    CORROSIVE,

    POISON,
    SOUL,

    SHAME;

    public static final int count = DamageType.values().length;

}
