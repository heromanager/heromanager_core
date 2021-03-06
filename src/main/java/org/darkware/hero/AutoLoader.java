package org.darkware.hero;

import com.google.common.reflect.ClassPath;
import org.darkware.hero.annotations.AutoLoad;
import org.darkware.hero.annotations.LoadKey;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jeff
 * @since 2015-09-02
 */
public class AutoLoader
{
    protected static ClassPath classPath;

    private static final ClassPath getClassPath()
    {
        if (AutoLoader.classPath == null)
        {
            try
            {
                AutoLoader.classPath = ClassPath.from(AutoLoader.class.getClassLoader());
            }
            catch (IOException e)
            {
                throw new IllegalStateException("Cannot load classpath for the base environment.");
            }
        }

        return AutoLoader.classPath;
    }

    public static Set<Class<?>> findAutoLoadTargets(LoadKey key)
    {
        return AutoLoader.findAutoLoadTargets(AutoLoader.class.getPackage().getName(), key);
    }

    public static Set<Class<?>> findAutoLoadTargets(Object example, LoadKey key)
    {
        return AutoLoader.findAutoLoadTargets(example.getClass().getPackage().getName(), key);
    }

    public static Set<Class<?>> findAutoLoadTargets(String basePackage, LoadKey key)
    {
        if (key == null) throw new IllegalArgumentException("Attempted to autoload with a null load key.");
        Set<Class<?>> targets = new HashSet<>();

        for (ClassPath.ClassInfo info : AutoLoader.getClassPath().getTopLevelClassesRecursive(basePackage))
        {
            Class<?> targetClass = info.load();
            AutoLoad autoLoadConfig = targetClass.getAnnotation(AutoLoad.class);
            if (autoLoadConfig != null)
            {
                if (key.equals(autoLoadConfig.key()))
                {
                    targets.add(targetClass);
                }
            }
        }

        return targets;
    }
}
