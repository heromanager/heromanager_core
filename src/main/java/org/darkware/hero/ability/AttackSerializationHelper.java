package org.darkware.hero.ability;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * @author jeff
 * @since 2015-08-07
 */
public class AttackSerializationHelper implements JsonSerializer<Attack>, JsonDeserializer<Attack>
{
    public Attack deserialize(final JsonElement jsonElement, final Type type,
                                        final JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException
    {
        JsonObject json = jsonElement.getAsJsonObject();

        Attack attack = new Attack();

        return attack;
    }

    public JsonElement serialize(final Attack attack, final Type type,
                                 final JsonSerializationContext jsonSerializationContext)
    {
        JsonObject modelObject = new JsonObject();

        modelObject.add("baseDamage", new JsonPrimitive(attack.getBaseDamageType().name()));

        modelObject.add("minDamage", new JsonPrimitive(attack.getMinDamage()));
        modelObject.add("maxDamage", new JsonPrimitive(attack.getMaxDamage()));

        return modelObject;
    }
}
