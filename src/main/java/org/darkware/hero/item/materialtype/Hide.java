package org.darkware.hero.item.materialtype;

import org.darkware.hero.annotations.AutoLoad;
import org.darkware.hero.annotations.LoadKey;

/**
 * @author jeff
 * @since 2015-09-02
 */
@AutoLoad(key = LoadKey.MATERIALTYPE)
public class Hide extends MaterialType
{
    public Hide()
    {
        super("HIDE", "Hide");
    }
}
