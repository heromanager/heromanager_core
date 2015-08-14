package org.darkware.hero.people;

import org.darkware.hero.base.EnumValueSet;

/**
 * @author jeff
 * @since 2015-08-07
 */
public class SimpleAttributes extends EnumValueSet<Attribute> implements Attributes
{
    public SimpleAttributes(int defaultValue)
    {
        super(defaultValue, Attribute.class);
    }

    public SimpleAttributes()
    {
        this(0);
    }
}
