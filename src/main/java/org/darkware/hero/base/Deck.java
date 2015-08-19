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
     * Creates a new Deck which has been filtered by one or more DeckFilters.
     *
     * @param filters The filters to pass items through.
     * @return A Deck containing only items allowed by all filters.
     */
    public Deck<T> filter(DeckFilter<T> ... filters)
    {
        final Deck<T> filtered = new Deck<T>();

        this.access.readLock().lock();
        try
        {
            for (T item : this.items)
            {
                for (DeckFilter<T> filter : filters)
                {
                    if (filter.allowItem(item)) filtered.add(item);
                }
            }
        }
        finally { this.access.readLock().unlock(); }

        return filtered;
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
