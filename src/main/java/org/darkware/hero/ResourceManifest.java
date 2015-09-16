package org.darkware.hero;

import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import org.darkware.hero.system.Serializer;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jeff
 * @since 2015-09-15
 */
public class ResourceManifest
{
    private Map<String, List<String>> manifest;

    protected ResourceManifest()
    {
        super();

        this.manifest = Serializer.global().fromJson(new TypeToken<Map<String, List<String>>>() {}.getType(),
                                                     Resources.getResource("manifest.json"));
    }

    public void printContents()
    {
        System.out.println("<< Manifest Contents >>");
        for (String section : this.manifest.keySet())
        {
            System.out.printf("[ %s ] x %d\n", section, this.manifest.get(section).size());
        }
    }

    public List<String> getResources(String section)
    {
        if (!this.manifest.containsKey(section)) return Collections.emptyList();

        return this.manifest.get(section);
    }

    public List<URL> getResourceURLs(String section)
    {
        List<URL> urls = this.getResources(section).stream().map(Resources::getResource).collect(Collectors.toList());

        return urls;
    }
}
