package arcanamod.arcana.common.items;

import arcanamod.arcana.Arcana;
import arcanamod.arcana.common.aspects.Aspect;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import org.jetbrains.annotations.NotNull;

public class CrystalItem extends Item {
    private final Aspect aspect;
    public CrystalItem(@NotNull Aspect aspect) {
        super(new FabricItemSettings().group(Arcana.CORE_GROUP));
        this.aspect = aspect;
    }
}
