package org.darkware.hero.base;

/**
 * @author jeff
 * @since 2015-09-14
 */
public interface ObjectFilter<T>
{
    /**
     * Check to see if this item is allowed by the filter.
     *
     * @param item The item to check.
     * @return <code>true</code> if the item doesn't conflict with the filter, <code>false</code>
     * if it does.
     */
    boolean allow(T item);
}
