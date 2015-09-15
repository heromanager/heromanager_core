package org.darkware.hero.item.material;

import org.darkware.hero.base.ObjectFilter;
import org.darkware.hero.item.materialtype.MaterialType;
import org.darkware.hero.item.model.Model;

/**
 * @author jeff
 * @since 2015-09-14
 */
public class MaterialTypeMaterialFilter implements ObjectFilter<Material>
{
    private final MaterialType materialType;

    public MaterialTypeMaterialFilter(MaterialType materialType)
    {
        super();

        this.materialType = materialType;
    }

    /**
     * Check to see if this material is allowed by the filter.
     *
     * @param material The material to check.
     * @return <code>true</code> if the model doesn't conflict with the filter, <code>false</code>
     * if it does.
     */
    @Override public boolean allow(Material material)
    {
        return material.getType().equals(this.materialType);
    }
}
