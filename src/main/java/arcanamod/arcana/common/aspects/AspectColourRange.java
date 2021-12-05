package arcanamod.arcana.common.aspects;

public class AspectColourRange {
    private final int[] colours;

    public AspectColourRange(int... colours) {
        this.colours = colours;
    }

    public int get(int colour){
        return colours[Math.min(colour, colours.length - 1)];
    }
}
