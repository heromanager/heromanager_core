package org.darkware.hero.system;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.sun.javaws.exceptions.InvalidArgumentException;
import org.darkware.hero.base.EnumFactorSet;
import org.darkware.hero.people.Attribute;
import org.darkware.hero.people.Attributes;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jeff
 * @since 2015-08-07
 */
public class AttributesSerializationHelper implements JsonSerializer<Attributes>, JsonDeserializer<Attributes>
{
    private Attribute translate(String name)
    {
        return Attribute.valueOf(name);
    }

    public Attributes deserialize(final JsonElement jsonElement, final Type type,
                                        final JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException
    {
        Attributes attrs = new Attributes();

        for (Map.Entry<String, JsonElement> entry: jsonElement.getAsJsonObject().entrySet())
        {
            attrs.set(this.translate(entry.getKey()), entry.getValue().getAsInt());
        }

        return attrs;
    }

    public JsonElement serialize(final Attributes attrs, final Type type,
                                 final JsonSerializationContext jsonSerializationContext)
    {
        JsonObject obj = new JsonObject();

        for (Attribute attr : attrs.allNonDefaultFields())
        {
            obj.add(attr.name(), new JsonPrimitive(attrs.get(attr)));
        }

        return obj;
    }
}
