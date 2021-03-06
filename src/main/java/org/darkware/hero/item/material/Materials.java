package org.darkware.hero.item.material;

import org.darkware.hero.GameEnvironment;
import org.darkware.hero.base.Deck;
import org.darkware.hero.base.InstanceLibrary;
import org.darkware.hero.base.StaticObjectLibrary;
import org.darkware.hero.item.materialtype.MaterialType;
import org.darkware.hero.item.materialtype.MaterialTypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author jeff
 * @since 2015-09-02
 */
public class Materials extends StaticObjectLibrary<Material>
{
    public static Materials global = new Materials();

    public Materials()
    {
        super();
    }

    public void load(GameEnvironment environment)
    {
        environment.getManifest().getResources("materials").forEach(this::loadFromTable);
    }

    private void loadFromTable(String resourcePath)
    {
        InputStream tableResource = this.getClass().getClassLoader().getResourceAsStream(resourcePath);
        BufferedReader tableReader = new BufferedReader(new InputStreamReader(tableResource));

        String line = null;
        try
        {
            while ((line = tableReader.readLine()) != null)
            {
                if (line.length() < 5) continue;
                if (!Character.isAlphabetic(line.charAt(0))) continue;

                String[] parts = line.split("\\s+");

                try
                {
                    MaterialBuilder builder = MaterialBuilder.create(parts[0], parts[1]);

                    builder.setType(MaterialTypes.global.get(parts[2]));
                    builder.setRarity(Integer.parseInt(parts[3]));
                    builder.setDensity(Double.parseDouble(parts[4]));
                    builder.setHardness(Double.parseDouble(parts[5]));
                    builder.setValue(Double.parseDouble(parts[6]));

                    this.add(builder);
                }
                catch (NumberFormatException e)
                {
                    //TODO Toss a warning
                }
            }
        }
        catch (IOException e)
        {
            //TODO Report the error
        }
    }

    private void add(MaterialBuilder builder)
    {
        Material mat = builder.build();
        this.insert(mat);
    }

    public Set<Material> forType(MaterialType type)
    {
        Set<Material> materials = this.getAll().stream().filter(mat -> type == mat.getType()).collect(Collectors.toSet());

        return materials;
    }

    public Deck<Material> typeDeck(MaterialType type)
    {
        Deck<Material> deck = new Deck<>();

        this.getAll().stream().filter(mat -> type == mat.getType()).forEach(mat -> deck.add(mat, mat.getRarity()));

        return deck;
    }
}
