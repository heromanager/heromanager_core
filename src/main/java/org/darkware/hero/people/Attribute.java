package org.darkware.hero.people;

/**
 * @author ${user}
 * @since 2015-08-07
 */
public enum Attribute
{
    BRAWN,
    FINESSE,
    INSIGHT,
    COURAGE,
    FITNESS,
    ALLURE;

    public final String displayName()
    {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
