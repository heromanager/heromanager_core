package org.darkware.hero.people.generation;

import org.darkware.hero.base.StaticId;
import org.darkware.hero.people.caste.Caste;
import org.darkware.hero.people.caste.Castes;
import org.darkware.hero.people.profession.Profession;
import org.darkware.hero.people.profession.Professions;
import org.darkware.hero.people.race.Race;
import org.darkware.hero.people.race.Races;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author jeff
 * @since 2015-08-24
 */
public class GroupCombos
{
    private static final GroupCombos global = new GroupCombos();

    public static GroupRestrictions restrictions(Race race)
    {
        return GroupCombos.global.getRestrictions(race);
    }

    public static GroupRestrictions restrictions(Caste caste)
    {
        return GroupCombos.global.getRestrictions(caste);
    }

    public static GroupRestrictions restrictions(Profession profession)
    {
        return GroupCombos.global.getRestrictions(profession);
    }

    private Map<StaticId, GroupRestrictions> raceRestrictions;
    private Map<StaticId, GroupRestrictions> casteRestrictions;
    private Map<StaticId, GroupRestrictions> profRestrictions;

    private GroupCombos()
    {
        super();

        this.raceRestrictions = new HashMap<>();
        this.casteRestrictions = new HashMap<>();
        this.profRestrictions = new HashMap<>();

        this.buildRestrictions();
    }

    /**
     * Builds a full set of base group restrictions based on defined incompatibilities
     * and their natural reversals. This means that a given pairing needs only be
     * declared from one direction. If a Race declares a Caste to be incompatible, this
     * method will record both the Race-to-Caste and Caste-to-Race restriction.
     */
    private void buildRestrictions()
    {
        for (Race race : Races.all())
        {
            for (Caste caste : race.getIncompatibleCastes())
            {
                this.getRestrictions(race).restrictCaste(caste.getId());
                this.getRestrictions(caste).restrictRace(race.getId());
            }

            for (Profession profession : race.getIncompatibleProfessions())
            {
                this.getRestrictions(race).restrictProfession(profession.getId());
                this.getRestrictions(profession).restrictRace(race.getId());
            }
        }

        for (Caste caste : Castes.all())
        {
            for (Race race : caste.getIncompatibleRaces())
            {
                this.getRestrictions(caste).restrictRace(race.getId());
                this.getRestrictions(race).restrictCaste(caste.getId());
            }

            for (Profession profession : caste.getIncompatibleProfessions())
            {
                this.getRestrictions(caste).restrictProfession(profession.getId());
                this.getRestrictions(profession).restrictRace(caste.getId());
            }
        }

        for (Profession profession : Professions.all())
        {
            for (Caste caste : profession.getIncompatibleCastes())
            {
                this.getRestrictions(profession).restrictCaste(caste.getId());
                this.getRestrictions(caste).restrictRace(profession.getId());
            }

            for (Race race : profession.getIncompatibleRaces())
            {
                this.getRestrictions(profession).restrictRace(race.getId());
                this.getRestrictions(race).restrictProfession(profession.getId());
            }
        }
    }

    /**
     * Fetch the GroupRestrictions associated with a given Race.
     *
     * @param race The Race to get the restrictions for.
     * @return A {@link GroupRestrictions} object for the given Race.
     */
    public GroupRestrictions getRestrictions(Race race)
    {
        if (!this.raceRestrictions.containsKey(race.getId()))
        {
            this.raceRestrictions.put(race.getId(), new GroupRestrictions());
        }

        return this.raceRestrictions.get(race.getId());
    }

    /**
     * Fetch the GroupRestrictions associated with a given Caste.
     *
     * @param caste The Caste to get the restrictions for.
     * @return A {@link GroupRestrictions} object for the given Caste.
     */
    public GroupRestrictions getRestrictions(Caste caste)
    {
        if (!this.casteRestrictions.containsKey(caste.getId()))
        {
            this.casteRestrictions.put(caste.getId(), new GroupRestrictions());
        }

        return this.casteRestrictions.get(caste.getId());
    }

    /**
     * Fetch the GroupRestrictions associated with a given Profession.
     *
     * @param profession The Profession to get the restrictions for.
     * @return A {@link GroupRestrictions} object for the given Profession.
     */
    public GroupRestrictions getRestrictions(Profession profession)
    {
        if (!this.profRestrictions.containsKey(profession.getId()))
        {
            this.profRestrictions.put(profession.getId(), new GroupRestrictions());
        }

        return this.profRestrictions.get(profession.getId());
    }
}
