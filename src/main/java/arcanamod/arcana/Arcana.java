package arcanamod.arcana;

import arcanamod.arcana.common.aspects.Aspects;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Arcana implements ModInitializer {
    public static String MODID = "arcana";
    public static ArcanaConfig config = null;

    @Override
    public void onInitialize() {
        config = ArcanaConfig.load();
        Aspects.initialize();
    }

    public static Identifier identifier(String path) {
        return new Identifier(MODID, path);
    }
    public static Identifier identifier() {
        return new Identifier(MODID);
    }
}
