package org.darkware.hero.ability;

/**
 * @author jeff
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

    SHAME,

    NONE;

    public static final int count = DamageType.values().length;

}
