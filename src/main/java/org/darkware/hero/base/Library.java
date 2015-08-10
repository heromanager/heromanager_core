package org.darkware.hero.base;

/**
 * @author jeff
 * @since 2015-07-27
 */
public interface Library<T>
{
    /**
     * Checks to see if the given key exists in the library.
     *
     * @param key The key to check
     * @return <code>true</code> if the key exists, <code>false</code> if it does not.
     */
    boolean has(StaticId key);

    /**
     * The maximum number of entries stored in the library at one time. A library with a
     * capacity of zero has no capacity limit and can contain as many items as are added
     * to it.
     *
     * @return The maximum number of entries the library can store.
     */
    int capacity();

    /**
     * The number of entries stored in the library at this time.
     *
     * @return The current number of stored entries.
     */
    int size();

    /**
     * Inserts a new entry into the library. If another entry with the same key already
     * exists, it will be removed before the new entry is added.
     *
     * @param key The key to store the item under.
     * @param item The item to store in the library.
     */
    void insert(StaticId key, T item);

    /**
     * Fetches an item from the library which was stored under the given key.
     *
     * @param key The key which identifies the item to fetch.
     * @return The item stored under the given key, or <code>null</code> if the key was
     * not found.
     */
    T get(StaticId key);

    /**
     * Removes the item associated with the given key from the library. This has no effect if
     * there are no items associated with the key.
     *
     * @param key The key associated with the item to remove.
     * @return The item which was removed, or <code>null</code> if no matching item was found.
     */
    T remove(StaticId key);

    /**
     * Removes all instances of the given item from the library. The matching of the item is
     * done using the standard {@link java.lang.Object#equals(Object)} method.
     *
     * Note: This may require iteration and when used with large libraries, may take quite a
     * while to complete.
     *
     * @param item The item to remove.
     * @return
     */
    int removeAll(T item);
}
