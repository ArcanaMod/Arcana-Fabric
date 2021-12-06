package arcanamod.arcana.common.aspects;

public record AspectColorRange(int... colors) {
    public int get(int color) {
        return colors[Math.min(color, colors.length - 1)];
    }
}