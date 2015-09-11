package org.darkware.hero.system;

import com.google.gson.*;
import org.darkware.hero.base.EnumFactorSet;

import java.lang.reflect.Type;

/**
 * @author jeff
 * @since 2015-08-07
 */
public class EnumFactorSetSerializaitonHelper<T extends Enum<T>> implements JsonSerializer<EnumFactorSet<T>>, JsonDeserializer<EnumFactorSet<T>>
{
    public EnumFactorSet<T> deserialize(final JsonElement jsonElement, final Type type,
                                        final JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException
    {
        return null;
    }

    public JsonElement serialize(final EnumFactorSet<T> tEnumFactorSet, final Type type,
                                 final JsonSerializationContext jsonSerializationContext)
    {
        JsonObject obj = new JsonObject();

        for (T item : tEnumFactorSet.allNonDefaultFields())
        {
            obj.add(item.name(), new JsonPrimitive(tEnumFactorSet.get(item)));
        }

        return obj;
    }
}
