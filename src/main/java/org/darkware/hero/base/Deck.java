package org.darkware.hero.base;

import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jeff
 * @since 2015-08-17
 */
public class Deck<T>
{
    private static final Random RNG = new Random();

    private final List<T> items;
    private final ReadWriteLock access;

    public Deck()
    {
        super();

        this.items = new ArrayList<T>();
        this.access = new ReentrantReadWriteLock(true);
    }

    public Deck(Collection<T> items)
    {
        this();

        this.items.addAll(items);
    }

    /**
     * Fetches the current size of the deck.
     *
     * @return The count of items in the deck.
     */
    public int size()
    {
        this.access.readLock().lock();
        try
        {
            return this.items.size();
        }
        finally { this.access.readLock().unlock(); }
    }

    /**
     * Creates a complete copy of this Deck.
     *
     * @return A new Deck, with the same contents and ordering of this Deck.
     */
    public Deck<T> clone()
    {
        Deck<T> newDeck = new Deck<>();

        newDeck.items.addAll(this.items);

        return newDeck;
    }

    /**
     * Adds a number of items to the deck.
     *
     * @param items The items to add.
     */
    public void add(T ... items)
    {
        this.access.writeLock().lock();
        try
        {
            Collections.addAll(this.items, items);
        }
        finally { this.access.writeLock().unlock(); }
    }

    /**
     * Adds a number of items to the deck.
     *
     * @param items The items to add.
     */
    public void add(Collection<T> items)
    {
        this.access.writeLock().lock();
        try
        {
            this.items.addAll(items);
        }
        finally { this.access.writeLock().unlock(); }
    }

    /**
     * Adds an item to the deck with the given weight. Weighted items are represented
     * multiple times in the deck, thus increasing the chance that they show up on
     * any random pick, or ensuring that multiple instances are drawn on an iterative
     * draw.
     *
     * @param item The item to add.
     * @param weight The number of duplicated added to the deck.
     */
    public void add(T item, int weight)
    {
        this.access.writeLock().lock();
        try
        {
            for (int i = 0; i <= weight; i++) this.items.add(item);
        }
        finally { this.access.writeLock().unlock(); }
    }

    /**
     * Removes all items from the deck.
     */
    public void clear()
    {
        this.access.writeLock().lock();
        try
        {
            this.items.clear();
        }
        finally { this.access.writeLock().unlock(); }
    }

    /**
     * Filters items of the Deck, removing items denied by the filter.
     *
     * @param filters The filters to pass items through.
     */
    public void filter(DeckFilter<T> ... filters)
    {
        //OPTIMIZE: Use a filter cache to reduce filter checks of duplicated items.

        this.access.writeLock().lock();
        try
        {
            Iterator<T> i = this.items.iterator();
            while (i.hasNext())
            {
                if (!this.passFilters(i.next(), filters)) i.remove();
            }
        }
        finally { this.access.writeLock().unlock(); }
    }

    /**
     * Creates a copy of this deck, consisting of items filtered through the
     * supplied filters.
     *
     * @param filters The filters to pass all items through
     * @return A new Deck.
     */
    public Deck<T> filteredCopy(DeckFilter<T> ... filters)
    {
        //OPTIMIZE: Use a filter cache to reduce filter checks on duplicated items.

        Deck<T> copy = new Deck<>();

        this.access.writeLock().lock();
        try
        {
            this.items.stream().filter(item -> this.passFilters(item, filters)).forEach(copy::add);
        }
        finally { this.access.writeLock().unlock(); }

        return copy;
    }

    /**
     * Checks an item against multiple filters. The result is the boolean conjunction of the result
     * of each filter. That is: if any result is false, then the composite result is false. The result
     * is true if and only if all results are true. The examination may short circuit as soon as a
     * single allowance check fails.
     *
     * @param item The item to check.
     * @param filters An array of filters to examine.
     * @return <code>true</code> if all filters allow the item, <code>false</code> if one or more filters
     * would exclude the item.
     */
    private boolean passFilters(T item, DeckFilter<T> ... filters)
    {
        for (DeckFilter<T> filter : filters)
        {
            if (!filter.allowItem(item))
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Randomizes the order of the items in the deck.
     */
    public void shuffle()
    {
        this.access.writeLock().lock();
        try
        {
            Collections.shuffle(this.items, Deck.RNG);
        }
        finally { this.access.writeLock().unlock(); }
    }

    /**
     * Selects a random item from anywhere within the deck. The item remains in the
     * deck, and the order is unchanged.
     *
     * @return A random item from the deck.
     */
    public T pick()
    {
        this.access.writeLock().lock();
        try
        {
            if (this.items.size() < 1) throw new IllegalStateException("Cannot pick from an empty deck.");
            return this.items.get(Deck.RNG.nextInt(this.items.size()));
        }
        finally { this.access.writeLock().unlock(); }
    }

    /**
     * Pulls an item from the top of the deck.
     *
     * @return The item which had been at the top of the deck.
     */
    public T take()
    {
        this.access.writeLock().lock();
        try
        {
            if (this.items.size() < 1) throw new IllegalStateException("Cannot take from an empty deck.");
            return this.items.remove(0);
        }
        finally { this.access.writeLock().unlock(); }
    }

    /**
     * Peeks at the item on the top of the deck, but does not remove it.
     *
     * @return The item on the top of the deck.
     */
    public T peek()
    {
        this.access.readLock().lock();
        try
        {
            if (this.items.size() < 1) throw new IllegalStateException("Cannot peek at an empty deck.");
            return this.items.get(0);
        }
        finally { this.access.readLock().unlock(); }
    }
}
