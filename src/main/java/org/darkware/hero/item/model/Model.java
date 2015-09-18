package org.darkware.hero.item.model;

import org.darkware.hero.base.NamedStaticObject;
import org.darkware.hero.base.Rarified;
import org.darkware.hero.base.StaticId;
import org.darkware.hero.ability.Attack;
import org.darkware.hero.ability.DamageType;
import org.darkware.hero.ability.Defense;
import org.darkware.hero.item.Item;
import org.darkware.hero.item.ItemSlot;
import org.darkware.hero.item.materialtype.MaterialType;
import org.darkware.hero.people.skills.Skill;
import org.darkware.hero.system.EngineInitializationError;

/**
 * @author jeff
 * @since 2015-09-01
 */
public class Model extends NamedStaticObject implements Rarified
{
    private static final int MAX_SMITHING_DIFFICULTY = Skill.MAX_VALUE - 20;

    private ItemSlot slot;
    private int rarity;

    private MaterialType materialType;
    private double volume;
    private double valueFactor;

    private Skill skill;
    private int minSkill;
    private double skillBonus;

    private Attack attack;
    private Defense defense;

    private int smithingDifficulty;

    /**
     * Creates a new Model with default values.
     *
     * @param id The ID of this model.
     * @param name The friendly name of the model.
     */
    public Model(final StaticId id, final CharSequence name)
    {
        super(id, name);

        // materialType is left unset
        this.rarity = 10;

        this.slot = ItemSlot.ARMS;
        this.volume = 1.0;

        this.skill = Skill.NONE;
        this.minSkill = 1;
        this.skillBonus = 2.0;

        this.attack = null;
        this.defense = null;

        this.smithingDifficulty = 1;
    }

    /**
     * Creates a new Model with default values.
     *
     * @param id The ID of this model.
     * @param name The friendly name of the model.
     * @see Model#Model(StaticId, CharSequence)
     */
    public Model(final String id, final CharSequence name)
    {
        this(new StaticId(id), name);
    }

    /**
     * Fetches the slot this item is equipped under.
     *
     * @return An {@link ItemSlot}.
     */
    public ItemSlot getSlot()
    {
        return this.slot;
    }

    /**
     * Sets the slot this item is equipped under.
     *
     * @param slot The {@link ItemSlot} to use.
     */
    protected void setSlot(ItemSlot slot)
    {
        this.slot = slot;
    }

    /**
     * Fetch the MaterialType this model uses.
     *
     * @return A {@link MaterialType}.
     */
    public MaterialType getMaterialType()
    {
        return materialType;
    }

    /**
     * Set the MaterialType used by this model.
     *
     * @param materialType A {@link MaterialType}.
     */
    protected void setMaterialType(final MaterialType materialType)
    {
        this.materialType = materialType;
    }

    /**
     * Fetch the rarity of this model in comparison to other models. Higher rarities
     * indicate more common models.
     *
     * @return The rarity, as an integer.
     * @see Rarified
     */
    @Override public int getRarity()
    {
        return this.rarity;
    }

    /**
     * Sets the rarity of this model.
     *
     * @param rarity The rarity as a positive integer.
     * @see Model#getRarity()
     */
    public void setRarity(final int rarity)
    {
        if (rarity < 1) throw new IllegalArgumentException("Rarity must be a positive integer.");
        this.rarity = rarity;
    }

    /**
     * Fetch the volume of material used for this model. This is used in calculating
     * an {@link org.darkware.hero.item.Item}'s weight, value, and smithing requirements.
     *
     * @return The volume of materials used for this model, in standard lumps.
     */
    public double getVolume()
    {
        return volume;
    }

    /**
     * Sets the volume of Material used for this model.
     *
     * @param volume The volume, as a positive double.
     */
    protected void setVolume(final double volume)
    {
        if (volume <= 0.0) throw new IllegalArgumentException("Volume must be greater than zero.");
        this.volume = volume;
    }

    /**
     * Fetch the skill needed to use this model.
     *
     * @return The {@link Skill} used by this model.
     */
    public Skill getSkill()
    {
        return skill;
    }

    /**
     * Sets the skill used for this model.
     *
     * @param skill The {@link Skill} to use.
     */
    protected void setSkill(final Skill skill)
    {
        if (skill == null) throw new IllegalArgumentException("Cannot set a null skill for a model.");
        this.skill = skill;
    }

    /**
     * Fetches the minimum skill level required to use this model.
     *
     * @return The minimum skill level, as a positive integer.
     */
    public int getMinSkill()
    {
        return minSkill;
    }

    /**
     * Sets the minimum skill required for this model.
     *
     * @param minSkill The minimum skill level, as a positive integer.
     */
    protected void setMinSkill(final int minSkill)
    {
        if (minSkill < 1) throw new IllegalArgumentException("Minimum skill level must be greater than zero.");
        this.minSkill = minSkill;
    }

    /**
     * Fetches the multiplicative factor this model has on the value of the materials used to make it.
     *
     * @return The value adjustment as a multiplicative factor greater than zero.
     * @see Item#getValue()
     */
    public double getValueFactor()
    {
        return valueFactor;
    }

    /**
     * Sets the value factor for this model.
     *
     * @param valueFactor The factor as a double which is greater than zero.
     */
    public void setValueFactor(final double valueFactor)
    {
        if (valueFactor <= 0.0) throw new IllegalArgumentException("Value factors must be greater than zero. (value = " + valueFactor + ")");
        this.valueFactor = valueFactor;
    }

    /**
     * Fetch the bonus damage factor applied based on the amount of extra skill a Hero has.
     *
     * @return The bonus factor, as a double greater than <code>1.0</code>.
     */
    public double getSkillBonus()
    {
        return skillBonus;
    }

    /**
     * Set the bonus damage factor for excess skill on this model.
     *
     * @param skillBonus The bonus factor, as a double greater than <code>1.0</code>
     */
    public void setSkillBonus(final double skillBonus)
    {
        if (skillBonus < 1.0) throw new IllegalArgumentException("Skill bonus factors must be greater than 1.0");
        this.skillBonus = skillBonus;
    }

    /**
     * Fetches the base difficulty of smithing items of this model. This is used to control
     * how much smithing skill is required to create the item.
     *
     * @return The difficulty as the {@link Skill#SMITHING} skill level required.
     */
    public int getSmithingDifficulty()
    {
        return smithingDifficulty;
    }

    /**
     * Fetches the volume of materials needed to smith this model.
     *
     * @return The volume of materials, as an integer.
     */
    public int getSmithingVolume()
    {
        return (int)Math.floor(this.getVolume() + 0.8);
    }

    /**
     * Sets the smithing difficulty.
     *
     * @param smithingDifficulty The difficulty as an integer.
     */
    public void setSmithingDifficulty(final int smithingDifficulty)
    {
        if (smithingDifficulty < 1) throw new IllegalArgumentException("Smithing difficulty must be greater than zero.");
        if (smithingDifficulty > Model.MAX_SMITHING_DIFFICULTY) throw new IllegalArgumentException("Smithing difficulty cannot exceed " + Model.MAX_SMITHING_DIFFICULTY);
        this.smithingDifficulty = smithingDifficulty;
    }

    /**
     * Checks to see if this model has a native attack. Models that have attacks can take part
     * in attacks during battle rounds.
     *
     * @return <code>true</code> if this model has an attack, <code>false</code> if it does not.
     */
    public boolean hasAttack()
    {
        return this.attack != null;
    }

    public Attack getAttack()
    {
        return this.attack;
    }

    public void setAttack(final Attack attack)
    {
        this.attack = attack;
    }

    /**
     * Checks to see if this model supplies defense. Models that have defenses will have their
     * defensive abilities used to mitigate incoming damage in battle.
     *
     * @return <code>true</code> if this model supplies defense, <code>false</code> if it does not.
     */
    public final boolean hasDefense()
    {
        return this.defense != null;
    }

    public Defense getDefense()
    {
        return this.defense;
    }

    public void setDefense(final Defense defense)
    {
        this.defense = defense;
    }

    protected void validate()
    {
        if (this.slot == null) throw new EngineInitializationError("Model " + this.getId() + " does not declare a slot.");
        if (this.rarity < 1) throw new EngineInitializationError("Model " + this.getId() + " has a rarity less than one.");
        if (this.volume < 0.0) throw new EngineInitializationError("Model " + this.getId() + " does not have a volume.");
        if (this.valueFactor < 0.0) throw new EngineInitializationError("Model " + this.getId() + " has a negative value factor.");

        if (this.skill == null) throw new EngineInitializationError("Model " + this.getId() + " does not declare a skill.");
        if (this.minSkill < 1) throw new EngineInitializationError("Model " + this.getId() + " has a negative minimum skill.");
        if (this.minSkill > 250) throw new EngineInitializationError("Model " + this.getId() + " has an excessively high minimum skill.");
        if (this.skillBonus < 1.0) throw new EngineInitializationError("Model " + this.getId() + " has a skill bonus that is below 1.0.");

        if (this.smithingDifficulty < 1) throw new EngineInitializationError("Model " + this.getId() + " has a negative smithing difficulty.");
        if (this.smithingDifficulty > 250) throw new EngineInitializationError("Model " + this.getId() + " has an excessively high smithing difficulty.");

        if (this.hasAttack())
        {
            if (this.attack.getBaseDamageType() == DamageType.NONE)
                throw new EngineInitializationError("Model " + this.getId() + " has a primary damage type of NONE.");
            if (this.attack.getMinDamage() < 1)
                throw new EngineInitializationError("Model " + this.getId() + " has a non-postive minimum damage.");
            if (this.attack.getMaxDamage() > this.attack.getMaxDamage())
                throw new EngineInitializationError("Model " + this.getId() + " has an invalid damage range.");

            if (this.attack.hasSecondaryDamage())
            {
                if (this.attack.getSecondaryDamageType() == this.attack.getBaseDamageType())
                    throw new EngineInitializationError("Model " + this.getId() + " has a matching primary and secondary attack damage type.");
                if (this.attack.getSecondaryPortion() <= 0.0)
                    throw new EngineInitializationError("Model " + this.getId() + " has a secondary damage portion that is too low.");
                if (this.attack.getSecondaryPortion() > 0.5)
                    throw new EngineInitializationError("Model " + this.getId() + " has a secondary damage portion that is too high.");
            }
        }

        if (this.hasDefense())
        {
            for (DamageType type : DamageType.values())
            {
                double value = this.defense.get(type);

                if (value <= 0.0)
                    throw new EngineInitializationError("Model " + this.getId() + " has over 100% defense vs " + type.name());
            }
        }
    }
}
