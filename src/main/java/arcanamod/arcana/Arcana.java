package arcanamod.arcana;

import net.fabricmc.api.ModInitializer;

public class Arcana implements ModInitializer {
    public static String MODID = "Arcana";
    public static ArcanaConfig config = null;

    @Override
    public void onInitialize() {
        config = ArcanaConfig.load();

    }
}
