package org.darkware.hero.people;

import org.darkware.hero.people.caste.Caste;
import org.darkware.hero.people.health.Health;
import org.darkware.hero.people.profession.Profession;
import org.darkware.hero.people.race.Race;
import org.darkware.hero.people.tags.Tags;

/**
 * @author jeff
 * @since 2015-08-05
 */
public class Hero extends Person
{
    private Profession profession;

    private final CompoundAttributes activeAttributes;
    private final SimpleAttributes baseAttributes;
    private final Tags tags;

    private final Health health;

    public Hero()
    {
        super();

        this.baseAttributes = new SimpleAttributes(40);
        this.activeAttributes = new CompoundAttributes();
        this.tags = new Tags();

        this.activeAttributes.addComponent("base", this.baseAttributes);

        this.health = new Health();
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

        this.activeAttributes.addComponent("profession", profession.getAttributes());
        this.tags.addSource("profession", profession.getTags());
    }

    @Override public void setCaste(final Caste caste)
    {
        super.setCaste(caste);

        this.activeAttributes.addComponent("caste", caste.getAttributes());
        this.tags.addSource("caste", caste.getTags());
    }

    @Override public void setRace(final Race race)
    {
        super.setRace(race);

        this.activeAttributes.addComponent("race", race.getAttributes());
        this.tags.addSource("race", race.getTags());
    }

    public Attributes getBaseAttributes()
    {
        return baseAttributes;
    }

    public Attributes getActiveAttributes()
    {
        return this.activeAttributes;
    }

    public Tags getTags()
    {
        return this.tags;
    }
}
