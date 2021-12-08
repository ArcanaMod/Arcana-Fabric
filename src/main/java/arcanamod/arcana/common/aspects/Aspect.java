package arcanamod.arcana.common.aspects;

import arcanamod.arcana.Arcana;
import net.minecraft.util.Identifier;

public class Aspect {
    private final AspectColorRange aspectColors;

    public Aspect(AspectColorRange colors) {
        this.aspectColors = colors;
    }

    public Identifier getId() {
        return Aspects.ASPECTS.getId(this);
    }
    public AspectColorRange getAspectColors() {
        return aspectColors;
    }

    @Override
    public String toString() {
        return Aspects.ASPECTS.getId(this).getPath();
    }
}
