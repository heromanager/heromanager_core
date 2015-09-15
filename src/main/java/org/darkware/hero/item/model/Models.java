package org.darkware.hero.item.model;

import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import org.darkware.hero.base.StaticObjectLibrary;
import org.darkware.hero.item.materialtype.MaterialTypes;
import org.darkware.hero.item.materialtype.Metal;
import org.darkware.hero.system.Serializer;

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

    @Override protected void prepopulate()
    {
        super.prepopulate();

        //TODO: Handle the serializer cache
        List<Model> loaded = Serializer.global().fromJson(new TypeToken<List<Model>>() {}.getType(),
                                                          Resources.getResource("models.json"));

        loaded.forEach(this::insert);
    }
}
