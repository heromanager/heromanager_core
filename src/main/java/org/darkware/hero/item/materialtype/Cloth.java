package org.darkware.hero.item.materialtype;

import org.darkware.hero.annotations.AutoLoad;
import org.darkware.hero.annotations.LoadKey;

/**
 * @author jeff
 * @since 2015-09-02
 */
@AutoLoad(key = LoadKey.MATERIALTYPE)
public class Cloth extends MaterialType
{
    public Cloth()
    {
        super("CLTH", "Cloth");
    }
}
