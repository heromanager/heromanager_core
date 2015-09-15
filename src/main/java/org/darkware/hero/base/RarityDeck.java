package org.darkware.hero.base;

import org.darkware.hero.util.RNG;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author jeff
 * @since 2015-09-14
 */
public class RarityDeck<T extends Rarified>
{
    private final List<T> items;

    public RarityDeck()
    {
        super();

        this.items = new ArrayList<>();
        this.populate();
    }

    protected void populate()
    {

    }

    public void add(T item)
    {
        this.items.add(item);
    }

    public void add(Collection<T> items)
    {
        this.items.addAll(items);
    }

    public void filter(ObjectFilter<T> filter)
    {
        Iterator<T> iterator = this.items.iterator();
        while (iterator.hasNext())
        {
            if (!filter.allow(iterator.next())) iterator.remove();
        }
    }

    public T pick()
    {
        return RNG.pickWithRarity(this.items);
    }

    public T pick(int targetRarity, int targetSize, double weight)
    {
        return RNG.pickWithRarity(this.items, targetRarity, targetSize, weight);
    }

    public int size()
    {
        return this.items.size();
    }
}
