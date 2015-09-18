package org.darkware.hero.item.model;

import com.google.gson.*;
import org.darkware.hero.base.StaticId;
import org.darkware.hero.ability.Attack;
import org.darkware.hero.ability.DamageType;
import org.darkware.hero.ability.Defense;
import org.darkware.hero.item.ItemSlot;
import org.darkware.hero.item.materialtype.MaterialTypes;
import org.darkware.hero.people.skills.Skill;
import org.darkware.hero.system.DataLoadingError;
import org.darkware.hero.system.DeserializationCache;

import java.lang.reflect.Type;

/**
 * @author jeff
 * @since 2015-08-07
 */
public class ModelSerializationHelper implements JsonSerializer<Model>, JsonDeserializer<Model>
{
    public Model deserialize(final JsonElement jsonElement, final Type type,
                                        final JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException
    {
        JsonObject json = jsonElement.getAsJsonObject();

        String id = json.get("id").getAsString();
        String name = json.get("name").getAsString();

        Model model = new Model(id, name);

        if (json.has("inherit"))
        {
            StaticId baseId = new StaticId(json.get("inherit").getAsString());
            Model base = DeserializationCache.global.getModel(baseId);
            if (base == null) throw new DataLoadingError("Failed to find pre-loaded base model: " + baseId);

            model.setRarity(base.getRarity());
            model.setSlot(base.getSlot());

            model.setMaterialType(base.getMaterialType());
            model.setVolume(base.getVolume());
            model.setValueFactor(base.getValueFactor());

            model.setSkill(base.getSkill());
            model.setMinSkill(base.getMinSkill());
            model.setSkillBonus(base.getSkillBonus());

            if (base.hasAttack()) model.setAttack(base.getAttack().copy());
            if (base.hasDefense()) model.setDefense(base.getDefense().copy());
        }

        if (json.has("rarity"))
            model.setRarity(json.get("rarity").getAsInt());
        if (json.has("slot"))
            model.setSlot(ItemSlot.valueOf(json.get("slot").getAsString()));


        if (json.has("materialType"))
            model.setMaterialType(MaterialTypes.global.get(json.get("materialType").getAsString()));
        if (json.has("volume"))
            model.setVolume(json.get("volume").getAsDouble());
        if (json.has("valueFactor"))
            model.setValueFactor(json.get("valueFactor").getAsDouble());

        if (json.has("skill"))
            model.setSkill(Skill.valueOf(json.get("skill").getAsString()));
        if (json.has("minSkill"))
            model.setMinSkill(json.get("minSkill").getAsInt());
        if (json.has("skillBonus"))
            model.setSkillBonus(json.get("skillBonus").getAsDouble());

        if (json.has("attack"))
        {
            if (model.getAttack() == null) model.setAttack(new Attack());

            JsonObject attackObject = json.getAsJsonObject("attack");

            if (attackObject.has("type"))
                model.getAttack().setBaseDamageType(DamageType.valueOf(attackObject.get("type").getAsString()));
            if (attackObject.has("minDamage"))
                model.getAttack().setMinDamage(attackObject.get("minDamage").getAsInt());
            if (attackObject.has("maxDamage"))
                model.getAttack().setMaxDamage(attackObject.get("maxDamage").getAsInt());

            if (attackObject.has("secondary") || attackObject.has("secondaryPortion"))
            {
                DamageType secondary = model.getAttack().getSecondaryDamageType();
                double portion = model.getAttack().getSecondaryPortion();

                if (attackObject.has("secondary"))
                    secondary = DamageType.valueOf(attackObject.get("secondary").getAsString());
                if (attackObject.has("secondaryPortion"))
                    portion = attackObject.get("secondaryPortion").getAsDouble();

                model.getAttack().setSecondaryDamage(secondary, portion);
            }
        }

        if (json.has("defense"))
        {
            JsonObject defenseObject = json.getAsJsonObject("defense");
            Defense defense = new Defense();

            for (DamageType damage : DamageType.values())
            {
                if (defenseObject.has(damage.name()))
                {
                    double factor = defenseObject.get(damage.name()).getAsDouble();
                    defense.set(damage, 1.0 - factor);
                }
            }

            model.setDefense(defense);
        }

        if (json.has("smithingDifficulty"))
            model.setSmithingDifficulty(json.get("smithingDifficulty").getAsInt());

        // Validate the model
        model.validate();

        DeserializationCache.global.offer(model);
        return model;
    }

    public JsonElement serialize(final Model model, final Type type,
                                 final JsonSerializationContext jsonSerializationContext)
    {
        JsonObject modelObject = new JsonObject();

        modelObject.add("id", new JsonPrimitive(model.getId().toString()));
        modelObject.add("name", new JsonPrimitive(model.getName()));

        modelObject.add("rarity", new JsonPrimitive(model.getRarity()));

        modelObject.add("slot", new JsonPrimitive(model.getSlot().name()));
        modelObject.add("materialType", new JsonPrimitive(model.getMaterialType().getId().toString()));
        modelObject.add("volume", new JsonPrimitive(model.getVolume()));
        modelObject.add("valueFactor", new JsonPrimitive(model.getValueFactor()));

        modelObject.add("skill", new JsonPrimitive(model.getSkill().toString()));
        modelObject.add("minSkill", new JsonPrimitive(model.getMinSkill()));
        modelObject.add("skillBonus", new JsonPrimitive(model.getSkillBonus()));

        Attack attack = model.getAttack();
        if (attack != null)
        {
            JsonObject attackObject = new JsonObject();

            attackObject.add("type", new JsonPrimitive(attack.getBaseDamageType().name()));
            attackObject.add("minDamage", new JsonPrimitive(attack.getMinDamage()));
            attackObject.add("maxDamage", new JsonPrimitive(attack.getMaxDamage()));

            if (attack.getSecondaryDamageType() != DamageType.NONE)
            {
                attackObject.add("secondary", new JsonPrimitive(attack.getSecondaryDamageType().name()));
                attackObject.add("secondaryPortion", new JsonPrimitive(attack.getSecondaryPortion()));
            }

            modelObject.add("attack", attackObject);
        }

        Defense defense = model.getDefense();
        if (defense != null)
        {
            JsonObject defenseObject = new JsonObject();

            for (DamageType damage : DamageType.values())
            {
                double amount = defense.get(damage);
                if (amount != 1.0) defenseObject.add(damage.name(), new JsonPrimitive(amount));
            }

            modelObject.add("defense", defenseObject);
        }

        modelObject.add("smithingDifficulty", new JsonPrimitive(model.getSmithingDifficulty()));

        return modelObject;
    }
}
