package arcanamod.arcana;

import me.shedaniel.cloth.clothconfig.shadowed.com.moandjiezana.toml.Toml;
import me.shedaniel.cloth.clothconfig.shadowed.com.moandjiezana.toml.TomlWriter;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.IOException;

public class ArcanaConfig {
    private transient File file;

    private ArcanaConfig() {}
    public static ArcanaConfig load() {
        File file = new File(
                FabricLoader.getInstance().getConfigDir().toString(),
                Arcana.MODID + ".toml"
        );
        ArcanaConfig config;
        if (file.exists()) {
            Toml configTOML = new Toml().read(file);
            config = configTOML.to(ArcanaConfig.class);
            config.file = file;
        } else {
            config = new ArcanaConfig();
            config.file = file;
            config.save();
        }
        return config;
    }
    public void save() {
        TomlWriter writer = new TomlWriter();
        try {
            writer.write(this, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
