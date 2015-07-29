package org.darkware.hero.language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jeff
 * @since 2015-07-27
 */
public class PhonemeRegistry
{
    private final Map<PhonemeTag, List<String>> taggedList;

    public PhonemeRegistry()
    {
        super();

        this.taggedList = new HashMap<PhonemeTag, List<String>>();
    }

    public void register(String phoneme, PhonemeTag ... tags)
    {
        for (PhonemeTag tag : tags)
        {
            if (!this.taggedList.containsKey(tag)) this.taggedList.put(tag, new ArrayList<String>());
            this.taggedList.get(tag).add(phoneme);
        }
    }
}
