package org.darkware.hero.demo;

import org.darkware.hero.GameEnvironment;
import org.darkware.hero.item.ItemTemplate;

/**
 * @author jeff
 * @since 2015-08-05
 */
public class ItemGenDemo
{
    public static final void main(String ... args)
    {
        GameEnvironment.global.initialize();

        System.out.println("===== 10 Random Items =====");

        for (int i = 0; i < 10; i++)
        {
            ItemTemplate template = new ItemTemplate();
            System.out.printf("[%02d] %s\n", i, template.generate().getName());
        }
    }
}
