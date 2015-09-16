package org.darkware.hero.item.model;

import com.google.common.reflect.TypeToken;
import org.darkware.hero.GameEnvironment;
import org.darkware.hero.base.StaticObjectLibrary;
import org.darkware.hero.system.Serializer;

import java.net.URL;
import java.util.List;

/**
 * @author jeff
 * @since 2015-09-08
 */
public class Models extends StaticObjectLibrary<Model>
{
    public Models()
    {
        super();
    }

    public void load(GameEnvironment environment)
    {
        if (environment == null) throw new IllegalStateException("GameEnvironment is not initialized.");
        List<URL> resources = environment.getManifest().getResourceURLs("models");
        for (URL resource : resources)
        {
            List<Model> loaded = Serializer.global().fromJson(new TypeToken<List<Model>>(){}.getType(), resource);

            loaded.forEach(this::insert);
        }
    }
}
