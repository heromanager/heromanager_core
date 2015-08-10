package org.darkware.hero.people;

import org.darkware.hero.people.race.Race;

/**
 * @author jeff
 * @since 2015-08-05
 */
public class Person
{
    private String name;

    private Race race;
    private Caste caste;

    public Person()
    {
        super();
    }

    /**
     * Fetch the name of this Person.
     *
     * @return The name of the person.
     */
    public final String getName()
    {
        return this.name;
    }

    /**
     * Set the name of this person.
     *
     * @param name The new name to use.
     */
    public final void setName(String name)
    {
        this.name = name;
    }

    /**
     * Fetch the caste of this person.
     *
     * @return The person's assigned {@link Caste}.
     */
    public Caste getCaste()
    {
        return caste;
    }

    /**
     * Set the person's caste.
     *
     * @param caste The new {@link Caste} to use.
     */
    public void setCaste(final Caste caste)
    {
        this.caste = caste;
    }

    /**
     * Fetch the race of this person.
     *
     * @return The person's assigned {@link Race}.
     */
    public Race getRace()
    {
        return race;
    }

    /**
     * Set the person's race.
     *
     * @param race The new {@link Race} to use.
     */
    public void setRace(final Race race)
    {
        this.race = race;
    }
}
