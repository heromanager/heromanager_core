package org.darkware.hero.people;

import org.darkware.hero.base.EnumNameComparator;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author ${user}
 * @since 2015-08-12
 */
public interface Attributes
{
    int get(Attribute attr);

    void set(Attribute attr, int value);

    void set(String attrName, int value);

    void add(Attribute attr, int delta);

    void reset(Attribute attr);
    void resetAll();

    Set<Attribute> allFields();

    Set<Attribute> allNonDefaultFields();

    double getDefaultValue();
}
