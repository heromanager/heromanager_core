package org.darkware.hero.item.material;

import org.darkware.hero.GameEnvironment;
import org.darkware.hero.base.RarityDeck;

/**
 * @author jeff
 * @since 2015-09-14
 */
public class MaterialDeck extends RarityDeck<Material>
{
    public MaterialDeck()
    {
        super();
    }

    @Override protected void populate()
    {
        super.populate();

        this.add(GameEnvironment.global.getMaterials().getAll());
    }
}
