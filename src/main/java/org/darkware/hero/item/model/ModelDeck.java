package org.darkware.hero.item.model;

import org.darkware.hero.GameEnvironment;
import org.darkware.hero.base.RarityDeck;

/**
 * @author jeff
 * @since 2015-09-14
 */
public class ModelDeck extends RarityDeck<Model>
{
    public ModelDeck()
    {
        super();
    }

    @Override protected void populate()
    {
        super.populate();

        this.add(GameEnvironment.global.getModels().getAll());
        this.size();
    }
}
