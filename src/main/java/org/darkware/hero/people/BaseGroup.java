package org.darkware.hero.people;

import org.darkware.hero.base.NamedStaticObject;
import org.darkware.hero.base.StaticId;

/**
 * @author jeff
 * @since 2015-08-05
 */
public abstract class BaseGroup extends NamedStaticObject
{
    private final Attributes attrs;

    public BaseGroup(CharSequence id, String name)
    {
        this(new StaticId(id), name);
    }

    public BaseGroup(StaticId id, String name)
    {
        super(id, name);

        this.attrs = new Attributes();

        this.applyBonuses();
    }

    public final Attributes getAttributes()
    {
        return this.attrs;
    }

    protected void applyBonuses()
    {

    }
}
