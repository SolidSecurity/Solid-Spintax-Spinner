package solid.spintax.spinner.SolidSpintax;

import java.util.ArrayList;

/**
 * <i>Solid Spintax Block</i>
 * <p>
 * A series of one or or more Spintax elements (Spintax switches or normal text)
 * comprising a block of text.
 * <p>
 * Implemented as an {@code ArrayList} of {@code SolidSpintaxElement}s.
 * 
 * @author Solid Security
 * @author Vivek Nair
 * @author Jacob Fuehne
 * @since 2.0.0
 */
public class SolidSpintaxBlock implements SolidSpintaxElement {

    private final ArrayList<SolidSpintaxElement> body;

    public SolidSpintaxBlock() {
        body = new ArrayList<>();
    }

    /**
     * Adds the provided {@code SolidSpintaxElement} to the block.
     * @param sswitch element to be added
     */
    public void addSwitch(SolidSpintaxElement sswitch) {
        body.add(sswitch);
    }

    @Override
    public String spin(int tag) {
        String out = "";
        int permutations = 0;
        for (SolidSpintaxElement sswitch : body) {
            int currPermutations = sswitch.countPermutations();
            if (currPermutations == 1) {
                out += sswitch.spin(0);
                continue;
            }
            int childTag = tag % currPermutations;
            out += sswitch.spin(childTag);
            tag = (tag - childTag) / currPermutations;
        }
        return out;
    }

    @Override
    public String toString() {
        String out = "";
        out = body.stream().map((s) -> s.toString()).reduce(out, String::concat);
        out += "";
        return out;
    }

    @Override
    public int countPermutations() {
        int permutations = 1;
        permutations = body.stream().map((s) -> s.countPermutations()).reduce(permutations, (accumulator, _item) -> accumulator * _item);
        return permutations;
    }

    @Override
    public int countSwitches() {
        int switches = 0;
        switches = body.stream().map((s) -> s.countSwitches()).reduce(switches, Integer::sum);
        return switches;
    }
}
