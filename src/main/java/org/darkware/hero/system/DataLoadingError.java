package org.darkware.hero.system;

/**
 * @author jeff
 * @since 2015-09-12
 */
public class DataLoadingError extends EngineInitializationError
{
    public DataLoadingError(final String s, final Throwable throwable)
    {
        super(s, throwable);
    }

    public DataLoadingError(final String s)
    {
        super(s);
    }
}
