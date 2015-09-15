package org.darkware.hero;

import org.darkware.hero.item.material.Materials;
import org.darkware.hero.item.model.Models;

/**
 * @author jeff
 * @since 2015-07-7/28/2015
 */
public class GameEnvironment
{
    public static final GameEnvironment global = new GameEnvironment();

    private final Models models;
    private final Materials materials;

    public GameEnvironment()
    {
        super();

        this.models = new Models();
        this.materials = new Materials();
    }

    public final Models getModels()
    {
        return this.models;
    }

    public final Materials getMaterials()
    {
        return this.materials;
    }
}
