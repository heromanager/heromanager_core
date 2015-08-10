package org.darkware.hero.demo;

import org.darkware.hero.people.race.Race;
import org.darkware.hero.system.Serializer;

/**
 * @author ${user}
 * @since 2015-08-05
 */
public class JSONLoadDemo
{
    public static final void main(String ... args)
    {
        Race halfDragon = new Race("HDRG", "Half Dragon");

        System.out.println("JSON OUTPUT:");
        System.out.println(Serializer.global().toJson(halfDragon));
    }
}
