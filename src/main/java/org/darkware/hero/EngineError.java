package org.darkware.hero;

/**
 * @author jeff
 * @since 2015-09-12
 */
public class EngineError extends RuntimeException
{
    public EngineError(final String s, final Throwable throwable)
    {
        super(s, throwable);
    }

    public EngineError(final String s)
    {
        super(s);
    }
}
