package arcanamod.arcana.common.aspects;

import arcanamod.arcana.Arcana;
import arcanamod.arcana.common.util.StreamUtils;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Aspect oriented class
 * Contains functions to handle aspect easily
 */
public final class AspectTools {
    public static final Aspect[] primalAspects = new Aspect[]{Aspects.AIR, Aspects.CHAOS, Aspects.EARTH, Aspects.FIRE, Aspects.ORDER, Aspects.WATER};
    public static final Aspect[] sinAspects = new Aspect[]{Aspects.ENVY, Aspects.LUST, Aspects.SLOTH, Aspects.PRIDE, Aspects.GREED, Aspects.WRATH, Aspects.GLUTTONY};

    public static List<AspectStack> squish(List<AspectStack> stackList) {
        return StreamUtils.partialReduce(stackList, AspectStack::getAspect, (left, right) -> new AspectStack(left.getAspect(), left.getAmount() + right.getAmount()));
    }

    public static Identifier getAspectTextureLocation(Aspect aspect) {
        return Arcana.identifier("textures/aspect/" + aspect.getId().getPath() + ".png");
    }

    public static String getLocalizedAspectDisplayName(@NotNull Aspect aspect) {
        return I18n.translate(aspect.getId().toString().replace(":","."));
    }

    public static String getLocalizedAspectDescription(@NotNull Aspect aspect) {
        return I18n.translate(aspect.getId().toString().replace(":",".")+".desc");
    }
}