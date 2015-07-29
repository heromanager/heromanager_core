package org.darkware.hero.language;

/**
 * @author jeff
 * @since 2015-07-27
 */
public class NameGenDemo
{
    public static void main(final String ... args)
    {
        System.out.println("==== Name Generator Demo ====");
        
        WhelLanguage lang = new WhelLanguage();

        String fName = lang.createName(Gender.FEMALE);
        System.out.println("Female Name: " + fName);

        //String mName = lang.createName(Gender.MALE);
        //System.out.println("  Male Name: " + mName);

        System.exit(0);
    }
}
