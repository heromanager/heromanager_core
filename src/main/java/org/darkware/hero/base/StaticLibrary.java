package org.darkware.hero.base;

/**
 * @author ${user}
 * @since 2015-07-29
 */
public interface StaticLibrary<T extends StaticObject> extends Library<T>
{
    /**
     * Checks to see if the given item exists in the library, based solely upon its
     * ID.
     *
     * @param item The item to check for.
     * @return <code>true</code> if the item exists, <code>false</code> if it does not.
     */
    boolean has(T item);

    /**
     * Inserts a new entry into the library. If there is an existing entry that shares
     * the same key, it will be replaced with this item.
     *
     * @param item The item to store in the library.
     */
    void insert(T item);

    /**
     * Removes a single entry from the library based on its ID.
     *
     * @param item The item to remove.
     * @return The item that was removed.
     */
    T remove(final T item);
}
