package org.darkware.hero.people;

import org.darkware.hero.util.TextUtils;

import java.io.BufferedWriter;
import java.io.PrintStream;

/**
 * @author jeff
 * @since 2015-08-31
 */
public class HeroPrinter
{
    public static void print(Hero hero)
    {
        HeroPrinter.print(System.out, hero);
    }

    public static void print(PrintStream out, Hero hero)
    {
        out.printf("      Name: %s\n", hero.getName());
        out.printf("      Race: %s\n", hero.getRace().getName());
        out.printf("     Caste: %s\n", hero.getCaste().getName());
        out.printf("Profession: %s\n", hero.getProfession().getName());

        out.printf("      Tags: %s\n", TextUtils.join(", ", hero.getTags().getAll()));
    }
}
