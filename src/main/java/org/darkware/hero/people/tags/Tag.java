package org.darkware.hero.people.tags;

/**
 * @author jeff
 * @since 2015-08-31
 */
public enum Tag
{
    CURSED;

    private final TagHandler handler;

    Tag(TagHandler handler)
    {
        this.handler = handler;
    }

    Tag()
    {
        this(DefaultTagHandler.sharedInstance);
    }

    public final TagHandler handler()
    {
        return this.handler;
    }
}
