package arcanamod.arcana.common.items;

import arcanamod.arcana.Arcana;
import arcanamod.arcana.common.aspects.Aspect;
import arcanamod.arcana.common.aspects.Aspects;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;

public class ArcanaItems {

    private static final HashMap<Aspect, Item> ASPECT_CRYSTALS = Registration.createAspectItems();

    public static void initialize(){}

    public static class Registration {
        private static HashMap<Aspect, Item> createAspectItems() {
            HashMap<Aspect, Item> crystals = new HashMap<>();
            for(Aspect aspect : Aspects.getAll())
                if(aspect != Aspects.EMPTY){
                    Item crystal = new CrystalItem(aspect);
                    Registry.register(Registry.ITEM, Arcana.identifier(aspect.toString().toLowerCase() + "_crystal"), crystal);
                    crystals.put(aspect, crystal);
                }
            return crystals;
        }
    }
}
