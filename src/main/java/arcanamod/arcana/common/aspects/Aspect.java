package arcanamod.arcana.common.aspects;

import arcanamod.arcana.Arcana;

public class Aspect {
    private final int id;
    private final String aspectName;
    private final AspectColorRange aspectColors;

    private static int nextAspectId = 0;
    Aspect(String name, AspectColorRange colors) {
        this(name, colors, nextAspectId++);
    }

    private Aspect(String name, AspectColorRange colors, int id) {
        this.aspectName = name;
        this.aspectColors = colors;
        this.id = id;
        Aspects.ASPECTS.put(Arcana.identifier(name), this);
    }

    public int getId() {
        return id;
    }
    public String getAspectName() {
        return aspectName;
    }
    public AspectColorRange getAspectColors() {
        return aspectColors;
    }

    @Override
    public String toString() {
        return "Aspect: %s (%d)".formatted(aspectName, id);
    }
}
