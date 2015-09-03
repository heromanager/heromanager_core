package org.darkware.hero;

import com.google.common.reflect.ClassPath;
import org.darkware.hero.annotations.AutoLoad;
import org.darkware.hero.annotations.LoadKey;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jeff
 * @since 2015-07-7/28/2015
 */
public class GameEnvironment
{
    public static final GameEnvironment global = new GameEnvironment();

    private final ClassPath classPath;

    public GameEnvironment()
    {
        super();

        try
        {
            this.classPath = ClassPath.from(this.getClass().getClassLoader());
        }
        catch (IOException e)
        {
            throw new IllegalStateException("Cannot load classpath for the base environment.");
        }
    }

    public Set<Class<?>> findAutoLoadTargets(LoadKey key)
    {
        return this.findAutoLoadTargets(this, key);
    }

    public Set<Class<?>> findAutoLoadTargets(Object example, LoadKey key)
    {
        return this.findAutoLoadTargets(example.getClass().getPackage().getName(), key);
    }

    public Set<Class<?>> findAutoLoadTargets(String basePackage, LoadKey key)
    {
        Set<Class<?>> targets = new HashSet<>();

        for (ClassPath.ClassInfo info : this.classPath.getTopLevelClassesRecursive(basePackage))
        {
            Class<?> targetClass = info.load();
            AutoLoad autoLoadConfig = targetClass.getAnnotation(AutoLoad.class);
            if (autoLoadConfig != null && key.equals(autoLoadConfig.key()))
            {
                targets.add(targetClass);
            }
        }

        System.out.println("Found " + targets.size() + " autoload targets");
        return targets;
    }
}
