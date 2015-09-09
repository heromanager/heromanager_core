package org.darkware.hero.system;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.google.gson.*;
import org.darkware.hero.base.StaticId;
import org.darkware.hero.item.materialtype.MaterialType;
import org.darkware.hero.item.model.Model;
import org.darkware.hero.item.model.ModelSerializationHelper;
import org.darkware.hero.people.BaseGroup;
import org.darkware.hero.people.CompoundAttributes;
import org.darkware.hero.people.SimpleAttributes;
import org.darkware.hero.people.caste.Caste;
import org.darkware.hero.people.caste.Castes;
import org.darkware.hero.people.profession.Profession;
import org.darkware.hero.people.profession.Professions;
import org.darkware.hero.people.race.Race;
import org.darkware.hero.people.race.Races;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;

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

        builder.registerTypeAdapter(StaticId.class,
                                    (JsonSerializer<StaticId>) (staticId, type, jsonSerializationContext) -> {
                                        JsonPrimitive value = new JsonPrimitive(new String(staticId.getKey()));

                                        return value;
                                    });

        builder.registerTypeAdapter(StaticId.class,
                                    (JsonDeserializer<StaticId>) (jsonElement, type, jsonDeserializationContext) -> new StaticId(jsonElement.getAsString()));

        builder.registerTypeAdapter(SimpleAttributes.class, new AttributesSerializationHelper());
        builder.registerTypeAdapter(CompoundAttributes.class, new AttributesSerializationHelper());
        builder.registerTypeAdapter(MaterialType.class, new MaterialTypeSerializationHelper());
        builder.registerTypeAdapter(Model.class, new ModelSerializationHelper());

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

    public <T> T fromJson(Type type, URL data)
    {
        System.out.println("Deserialize string to class: " + type.getTypeName());

        try
        {
            //TODO: Maybe read from a buffer instead?
            String textData = Resources.toString(data, Charsets.UTF_8);
            return this.gson.fromJson(textData, type);
        }
        catch (IOException e)
        {
            //TODO: Log the error
            return null;
        }
    }
}
