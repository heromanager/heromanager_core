package org.darkware.hero.item.materialtype;

import org.darkware.hero.base.NamedStaticObject;
import org.darkware.hero.base.StaticId;

/**
 * @author jeff
 * @since 2015-09-02
 */
public class MaterialType extends NamedStaticObject
{
    public MaterialType(final String id, final CharSequence name)
    {
        super(new StaticId(id), name);
    }
}
