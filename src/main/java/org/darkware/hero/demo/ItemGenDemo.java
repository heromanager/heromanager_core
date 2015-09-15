package org.darkware.hero.demo;

import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import org.darkware.hero.GameEnvironment;
import org.darkware.hero.base.Range;
import org.darkware.hero.damage.Attack;
import org.darkware.hero.damage.Damage;
import org.darkware.hero.damage.DamageType;
import org.darkware.hero.item.ItemTemplate;
import org.darkware.hero.item.material.Material;
import org.darkware.hero.item.material.Materials;
import org.darkware.hero.item.materialtype.MaterialType;
import org.darkware.hero.item.materialtype.MaterialTypes;
import org.darkware.hero.item.model.Model;
import org.darkware.hero.item.model.Models;
import org.darkware.hero.people.Hero;
import org.darkware.hero.people.HeroGenerator;
import org.darkware.hero.people.HeroPrinter;
import org.darkware.hero.people.HeroTemplate;
import org.darkware.hero.system.Serializer;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author jeff
 * @since 2015-08-05
 */
public class ItemGenDemo
{
    public static final void main(String ... args)
    {
        System.out.println("==== LOADED MODELS ====");
        System.out.println(Serializer.global().toJson(GameEnvironment.global.getModels().getAll()));

        System.out.println("===== 10 Random Items =====");

        for (int i = 0; i < 10; i++)
        {
            ItemTemplate template = new ItemTemplate();
            System.out.printf("[%02d] %s\n", i, template.generate().getName());
        }
    }
}
