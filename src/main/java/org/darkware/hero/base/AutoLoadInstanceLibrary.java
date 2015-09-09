package org.darkware.hero.base;

import org.darkware.hero.AutoLoader;
import org.darkware.hero.annotations.LoadKey;

/**
 * @author jeff
 * @since 2015-09-02
 */
public abstract class AutoLoadInstanceLibrary<T extends StaticObject> extends InstanceLibrary<T>
{
    public AutoLoadInstanceLibrary()
    {
        super();
    }

    protected abstract LoadKey getAutoLoadKey();

    @Override protected void populate()
    {
        super.populate();

        this.autoload();
    }

    protected final void autoload()
    {
        for (Class<?> target : AutoLoader.findAutoLoadTargets(this, this.getAutoLoadKey()))
        {
            try
            {
                System.out.println("AUTOLOAD[" + this.getAutoLoadKey().name() + "] => " + target.getName());
                T r = (T)target.newInstance();
                this.add(r);
            }
            catch (Exception e)
            {
                //TOOD: Log the warning and move on
                System.err.println("FAILED to instantiate auto-load target: " + target.getName());
            }
        }
    }
}
