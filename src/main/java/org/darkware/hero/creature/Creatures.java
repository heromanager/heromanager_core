package org.darkware.hero.creature;

import org.darkware.hero.creature.type.CreatureTypeLibrary;

/**
 * @author ${user}
 * @since 2015-07-29
 */
public class Creatures
{
    private static final CreatureTypeLibrary typeLibrary = new CreatureTypeLibrary();

    public static CreatureTypeLibrary types() { return Creatures.typeLibrary; }
}
