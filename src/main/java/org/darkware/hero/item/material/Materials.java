package org.darkware.hero.item.material;

import org.darkware.hero.base.InstanceLibrary;
import org.darkware.hero.item.materialtype.MaterialTypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author jeff
 * @since 2015-09-02
 */
public class Materials extends InstanceLibrary<Material>
{
    public static Materials global = new Materials();

    protected Materials()
    {
        super();
        System.out.println("Initializing materials.");
    }

    @Override protected void populate()
    {
        super.populate();

        this.loadFromTable();
    }

    private void loadFromTable()
    {
        InputStream tableResource = this.getClass().getClassLoader().getResourceAsStream("material.table");
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
        System.out.println("Material: Added " + mat.getName() + " [" + mat.getId() + "]");
        this.add(mat);
    }
}
