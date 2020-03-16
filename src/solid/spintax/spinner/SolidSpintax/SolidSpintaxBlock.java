package solid.spintax.spinner.SolidSpintax;

import java.math.BigInteger;
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
    public String spin(BigInteger permutation) {
        String out = "";
        for (SolidSpintaxElement sswitch : body) {
            BigInteger currPermutations = sswitch.countPermutations();
            BigInteger childPermutation = permutation.mod(currPermutations);
            out += sswitch.spin(childPermutation);
            permutation = (permutation.subtract(childPermutation)).divide(currPermutations);
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
    public BigInteger countPermutations() {
        BigInteger permutations = BigInteger.ONE;
        for (SolidSpintaxElement s : body) {
            permutations = permutations.multiply(s.countPermutations());
        }
        return permutations;
    }
    
    @Override
    public int countSwitches() {
        int switches = 0;
        switches = body.stream().map((s) -> s.countSwitches()).reduce(switches, Integer::sum);
        return switches;
    }
}
