package org.darkware.hero.system;

import org.darkware.hero.EngineError;

/**
 * @author jeff
 * @since 2015-09-12
 */
public class EngineInitializationError extends EngineError
{
    public EngineInitializationError(final String s, final Throwable throwable)
    {
        super(s, throwable);
    }

    public EngineInitializationError(final String s)
    {
        super(s);
    }
}
