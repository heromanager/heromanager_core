package org.darkware.hero.people.health;

import org.darkware.hero.base.Portion;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jeff
 * @since 2015-08-15
 */
public class Health
{
    private static Map<Body, Portion> initializeBody()
    {
        Map<Body, Portion> body = new ConcurrentHashMap<Body, Portion>();

        for ( Body part : Body.values() )
        {
            body.put(part, new Portion(100));
        }

        return body;
    }

    private final Map<Body, Portion> body;

    public Health()
    {
        super();

        this.body = Health.initializeBody();
    }


}
