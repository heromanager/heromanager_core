package org.darkware.hero.base;

/**
 * @author jeff
 * @since 2015-08-18
 */
public interface DeckFilter<T>
{
    boolean allowItem(T item);
}
