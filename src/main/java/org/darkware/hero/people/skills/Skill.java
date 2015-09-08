package org.darkware.hero.people.skills;

/**
 * @author jeff
 * @since 2015-09-06
 */
public enum Skill
{
    BRAWLING,
    SWORD,
    TWO_HANDED_SWORD,
    AXE,
    CLUB,
    EXOTIC_WEAPONS,

    LIGHT_ARMOR,
    HEAVY_ARMOR,
    SHIELD,

    COOKING,
    RESEARCH,
    ARCANE_ARTS,
    THEOLOGY,
    SMITHING,

    LORE,
    SURVIVAL,
    HUNTING,

    NONE;

    public boolean trainable()
    {
        return (this != NONE);
    }
}
