package org.darkware.hero.system;

import org.darkware.hero.base.StaticId;
import org.darkware.hero.creature.Creature;
import org.darkware.hero.item.model.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jeff
 * @since 2015-09-12
 */
public class DeserializationCache
{
    public static final DeserializationCache global = new DeserializationCache();

    private final Map<StaticId, Model> models;
    private final Map<StaticId, Creature> creatures;

    private DeserializationCache()
    {
        super();

        this.models = new HashMap<>();
        this.creatures = new HashMap<>();
    }

    public boolean hasModel(StaticId id)
    {
        return this.models.containsKey(id);
    }

    public Model getModel(StaticId id)
    {
        return this.models.get(id);
    }

    public void offer(Model model)
    {
        this.models.put(model.getId(), model);
    }
}
