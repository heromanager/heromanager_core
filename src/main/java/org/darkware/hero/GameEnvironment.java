package org.darkware.hero;

import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import org.darkware.hero.item.material.Materials;
import org.darkware.hero.item.model.Models;
import org.darkware.hero.system.Serializer;
import org.darkware.hero.util.TextUtils;

import java.util.List;
import java.util.Map;

/**
 * @author jeff
 * @since 2015-07-7/28/2015
 */
public class GameEnvironment
{
    public static final GameEnvironment global = new GameEnvironment();

    private final ResourceManifest manifest;
    private final Models models;
    private final Materials materials;

    public GameEnvironment()
    {
        super();

        this.manifest = new ResourceManifest();
        this.manifest.printContents();

        this.models = new Models();
        this.materials = new Materials();
    }

    public final void initialize()
    {
        this.materials.load(this);
        this.models.load(this);
    }

    public final Models getModels()
    {
        return this.models;
    }

    public final Materials getMaterials()
    {
        return this.materials;
    }

    public final ResourceManifest getManifest()
    {
        return this.manifest;
    }
}
