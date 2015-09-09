package org.darkware.hero.system;

import com.google.gson.*;
import org.darkware.hero.item.materialtype.MaterialType;
import org.darkware.hero.item.materialtype.MaterialTypes;

import java.lang.reflect.Type;

/**
 * @author jeff
 * @since 2015-08-07
 */
public class MaterialTypeSerializationHelper implements JsonSerializer<MaterialType>, JsonDeserializer<MaterialType>
{
    public MaterialType deserialize(final JsonElement jsonElement, final Type type,
                                        final JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException
    {
        return MaterialTypes.global.get(jsonElement.getAsString());
    }

    public JsonElement serialize(final MaterialType materialType, final Type type,
                                 final JsonSerializationContext jsonSerializationContext)
    {
        return new JsonPrimitive(materialType.getId().toString());
    }
}
