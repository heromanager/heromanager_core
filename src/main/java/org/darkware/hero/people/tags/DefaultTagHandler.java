package org.darkware.hero.people.tags;

/**
 * @author jeff
 * @since 2015-08-31
 */
public class DefaultTagHandler implements TagHandler
{
    protected static final DefaultTagHandler sharedInstance = new DefaultTagHandler();

    public DefaultTagHandler()
    {
        super();
    }
}
