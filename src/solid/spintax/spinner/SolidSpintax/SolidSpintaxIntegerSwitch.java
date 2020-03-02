package solid.spintax.spinner.SolidSpintax;

public class SolidSpintaxIntegerSwitch implements SolidSpintaxElement {

    private final int min;
    private final int max;

    public SolidSpintaxIntegerSwitch(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String spin(int tag) {
        //Random rand = new Random();
        //absolute int range
        int range = max - min + 1;
        if (tag + min > max) {
            System.out.println("SolidIntSwitch tag not in range");
            return "ERROR";
        }
        int num = tag + min;
        String out = Integer.toString(num);
        return out;
    }

    @Override
    public String toString() {
        String out = "{";
        out += Integer.toString(min) + "-" + Integer.toString(max);
        out += "}";
        return out;
    }

    @Override
    public int countPermutations() {
        int permutations = max - min + 1;
        return permutations;
    }

    @Override
    public int countSwitches() {
        return 1;
    }
}