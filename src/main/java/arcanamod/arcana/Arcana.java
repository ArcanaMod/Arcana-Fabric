package arcanamod.arcana;

import arcanamod.arcana.common.aspects.Aspects;
import arcanamod.arcana.common.items.ArcanaItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class Arcana implements ModInitializer {
    public static String MODID = "arcana";
    public static ArcanaConfig config = null;

    public static final ItemGroup CORE_GROUP = FabricItemGroupBuilder.create(identifier("core")).icon(() -> new ItemStack(Items.BARRIER)).build();

    @Override
    public void onInitialize() {
        config = ArcanaConfig.load();
        Aspects.initialize();
        ArcanaItems.initialize();
    }

    public static Identifier identifier(String path) {
        return new Identifier(MODID, path);
    }
    public static Identifier identifier() {
        return new Identifier(MODID);
    }
}
