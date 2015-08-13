package org.darkware.hero.people;

import org.darkware.hero.people.profession.Profession;

/**
 * @author jeff
 * @since 2015-08-05
 */
public class Hero extends Person
{
    private Profession profession;

    public Hero()
    {
        super();
    }

    /**
     * Fetch the profession of this hero.
     *
     * @return The person's assigned {@link Profession}.
     */
    public final Profession getProfession()
    {
        return this.profession;
    }

    /**
     * Set the hero's caste.
     *
     * @param profession The new {@link Profession} to use.
     */
    public final void setProfession(Profession profession)
    {
        this.profession = profession;
    }

}
