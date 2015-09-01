package org.darkware.hero.people.tags;

import java.util.*;

/**
 * @author jeff
 * @since 2015-08-31
 */
public class Tags
{
    private final EnumSet<Tag> tags;
    private final Map<String, Tags> children;

    public Tags()
    {
        super();

        this.children = new HashMap<>();
        this.tags = EnumSet.noneOf(Tag.class);
    }

    public void addSource(String name, Tags child)
    {
        this.children.put(name, child);
    }

    public boolean has(Tag tag)
    {
        return this.tags.contains(tag);
    }

    public void add(Tag tag)
    {
        this.tags.add(tag);
    }

    public void remove(Tag tag)
    {
        this.tags.remove(tag);
    }

    public Set<Tag> getAll()
    {
        Set<Tag> allSet = new HashSet<>();

        for (Tag t : this.tags)
        {
            allSet.add(t);
        }

        for (Tags child : this.children.values())
        {
            allSet.addAll(child.getAll());
        }

        return allSet;
    }
}
