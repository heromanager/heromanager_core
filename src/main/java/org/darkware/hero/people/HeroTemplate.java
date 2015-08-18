package org.darkware.hero.people;

import org.darkware.hero.people.caste.Caste;
import org.darkware.hero.people.profession.Profession;
import org.darkware.hero.people.race.Race;

/**
 * @author jeff
 * @since 2015-08-17
 */
public class HeroTemplate
{
    private Race race;
    private Caste caste;
    private Profession profession;
    private Gender gender;
    private int level;

    public HeroTemplate()
    {
        super();
    }

    public Race getRace()
    {
        return race;
    }

    public void setRace(final Race race)
    {
        this.race = race;
    }

    public Caste getCaste()
    {
        return caste;
    }

    public void setCaste(final Caste caste)
    {
        this.caste = caste;
    }

    public Profession getProfession()
    {
        return profession;
    }

    public void setProfession(final Profession profession)
    {
        this.profession = profession;
    }

    public Gender getGender()
    {
        return gender;
    }

    public void setGender(final Gender gender)
    {
        this.gender = gender;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(final int level)
    {
        this.level = level;
    }
}
