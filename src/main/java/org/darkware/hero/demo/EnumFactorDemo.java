package org.darkware.hero.demo;

import org.darkware.hero.base.EnumFactorSet;
import org.darkware.hero.language.PhonemeTag;
import org.darkware.hero.people.Attribute;
import org.darkware.hero.people.Attributes;
import org.darkware.hero.system.Serializer;

/**
 * @author ${user}
 * @since 2015-08-07
 */
public class EnumFactorDemo
{
    public static final void main(String ... args)
    {
        /*
        EnumFactorSet phonemes = new EnumFactorSet(1.0, PhonemeTag.class);

        phonemes.apply(PhonemeTag.NAME_OBJ, 1.2);
        phonemes.apply(PhonemeTag.NAME_SUPER, 0.8);
        phonemes.set(PhonemeTag.GENERAL, 1.33);

        System.out.println("Phonemes:");
        System.out.println(phonemes.toString());

        System.out.println();

        System.out.println("As JSON:");
        System.out.println(Serializer.global().toJson(phonemes));
        */

        Attributes simpleAttrs = new Attributes();
        simpleAttrs.add(Attribute.ALLURE, 10);
        simpleAttrs.add(Attribute.BRAWN, 8);
        simpleAttrs.add(Attribute.FITNESS, 14);

        System.out.println();

        System.out.println("Attributes:");
        System.out.println(Serializer.global().toJson(simpleAttrs));

        String attrString = "{ \"ALLURE\": 19, \"BRAWN\": 1, \"FITNESS\": 13 }";
        Attributes parsedAttrs = Serializer.global().fromJson(Attributes.class, attrString);

        System.out.println();

        System.out.println("Parsed Attributes:");
        System.out.println(Serializer.global().toJson(parsedAttrs));
    }
}
