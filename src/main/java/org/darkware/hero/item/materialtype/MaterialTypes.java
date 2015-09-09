package org.darkware.hero.item.materialtype;

import org.darkware.hero.annotations.LoadKey;
import org.darkware.hero.base.AutoLoadInstanceLibrary;

/**
 * @author jeff
 * @since 2015-09-02
 */
public class MaterialTypes extends AutoLoadInstanceLibrary<MaterialType>
{
    public static MaterialTypes global = new MaterialTypes();

    public MaterialTypes()
    {
        super();
    }

    @Override protected LoadKey getAutoLoadKey()
    {
        return LoadKey.MATERIALTYPE;
    }
}
