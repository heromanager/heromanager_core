package org.darkware.hero.item.materialtype;

import org.darkware.hero.annotations.AutoLoad;
import org.darkware.hero.annotations.LoadKey;

/**
 * @author jeff
 * @since 2015-09-02
 */
@AutoLoad(key = LoadKey.MATERIALTYPE)
public class Wood extends MaterialType
{
    public Wood()
    {
        super("WOOD", "Wood");
    }
}
