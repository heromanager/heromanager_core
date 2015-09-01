package org.darkware.hero.system;

import com.google.gson.*;
import org.darkware.hero.base.StaticId;
import org.darkware.hero.people.BaseGroup;
import org.darkware.hero.people.CompoundAttributes;
import org.darkware.hero.people.SimpleAttributes;
import org.darkware.hero.people.caste.Caste;
import org.darkware.hero.people.caste.Castes;
import org.darkware.hero.people.profession.Profession;
import org.darkware.hero.people.profession.Professions;
import org.darkware.hero.people.race.Race;
import org.darkware.hero.people.race.Races;

import java.lang.reflect.Type;

/**
 * @author jeff
 * @since 2015-08-05
 */
public class Serializer
{
    private static Serializer instance = new Serializer();

    public static Serializer global()
    {
        return Serializer.instance;
    }

    private static void configureBuilder(GsonBuilder builder)
    {
        builder.setPrettyPrinting();

        builder.registerTypeAdapter(StaticId.class, new JsonSerializer<StaticId>()
        {
            public JsonElement serialize(final StaticId staticId, final Type type,
                                         final JsonSerializationContext jsonSerializationContext)
            {
                JsonPrimitive value = new JsonPrimitive(new String(staticId.getKey()));

                return value;
            }
        });

        builder.registerTypeAdapter(StaticId.class, new JsonDeserializer<StaticId>()
        {
            public StaticId deserialize(final JsonElement jsonElement, final Type type,
                                        final JsonDeserializationContext jsonDeserializationContext)
                    throws JsonParseException
            {
                return new StaticId(jsonElement.getAsString());
            }
        });

        builder.registerTypeAdapter(SimpleAttributes.class, new AttributesSerializationHelper());
        builder.registerTypeAdapter(CompoundAttributes.class, new AttributesSerializationHelper());

        builder.registerTypeHierarchyAdapter(BaseGroup.class, new JsonSerializer<BaseGroup>()
        {
            public JsonElement serialize(final BaseGroup group, final Type type,
                                         final JsonSerializationContext jsonSerializationContext)
            {
                return new JsonPrimitive(group.getId().toString());
            }
        });

        builder.registerTypeAdapter(Race.class, new JsonDeserializer<Race>()
        {
            public Race deserialize(final JsonElement jsonElement, final Type type,
                                    final JsonDeserializationContext jsonDeserializationContext)
                    throws JsonParseException
            {
                return Races.lookup(jsonElement.getAsString());
            }
        });

        builder.registerTypeAdapter(Caste.class, new JsonDeserializer<Caste>()
        {
            public Caste deserialize(final JsonElement jsonElement, final Type type,
                                    final JsonDeserializationContext jsonDeserializationContext)
                    throws JsonParseException
            {
                return Castes.lookup(jsonElement.getAsString());
            }
        });

        builder.registerTypeAdapter(Profession.class, new JsonDeserializer<Profession>()
        {
            public Profession deserialize(final JsonElement jsonElement, final Type type,
                                    final JsonDeserializationContext jsonDeserializationContext)
                    throws JsonParseException
            {
                return Professions.lookup(jsonElement.getAsString());
            }
        });

    }

    private final Gson gson;

    private Serializer()
    {
        super();

        GsonBuilder builder = new GsonBuilder();
        Serializer.configureBuilder(builder);

        this.gson = builder.create();
    }

    public String toJson(Object o)
    {
        return this.gson.toJson(o);
    }

    public <T> T fromJson(Class<T> tClass, String data)
    {
        System.out.println("Deserialize string to class: " + tClass.getCanonicalName());
        return this.gson.fromJson(data, tClass);
    }
}
