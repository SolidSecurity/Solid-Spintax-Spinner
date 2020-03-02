package solid.spintax.spinner.SolidSpintax;

import java.util.ArrayList;

/**
 * <i>Solid Spintax Switch</i>
 * <p>
 * A standard switch that chooses from amongst its children when spun.
 * 
 * Uses the
 * <a href="https://github.com/SolidSecurity/Solid-Spintax-Specification">Solid Spintax</a>
 * standard from <i>Solid Security</i>.
 * 
 * @author Solid Security
 * @author Vivek Nair
 * @author Jacob Fuehne
 * @since 2.0.0
 */
public class SolidSpintaxSwitch implements SolidSpintaxElement {
    private final ArrayList<SolidSpintaxElement> children;
    private final int switches = 0;

    public SolidSpintaxSwitch() {
        children = new ArrayList<>();
    }

    /**
     * Adds the provided {@code SolidSpintaxElement} to the switch.
     * @param child to be added to the switch
     * @since 2.0.0
     */
    public void addChild(SolidSpintaxElement child) {
        children.add(child);
    }

    @Override
    public String spin(int tag) {
        int length = children.size();
        //absolute int range
        for (int i = 0; i < children.size(); i++) {
            int curPermutations = children.get(i).countPermutations();
            if (tag < curPermutations) {
                return children.get(i).spin(tag);
            } else {
                tag -= curPermutations;
            }
        }
        System.out.println("Error: tag not reached");
        return "ERROR";
    }

    @Override
    public String toString() {
        String out = "{";
        Boolean first = true;
        for (SolidSpintaxElement s : children) {
            if (!first) {
                out += "|";
            }
            first = false;
            out += s.toString();
        }
        out += "}";
        return out;
    }

    /**
     * Returns an {@code ArrayList} of this switch's children.
     * @return list of children
     * @since 2.0.0
     */
    public ArrayList<SolidSpintaxElement> getChildren() {
        return children;
    }

    @Override
    public int countPermutations() {
        int permutations = 0;
        permutations = children.stream().map((s) -> s.countPermutations()).reduce(permutations, Integer::sum);
        return permutations;
    }

    @Override
    public int countSwitches() {
        int count = 1;
        count = children.stream().map((s) -> s.countSwitches()).reduce(count, Integer::sum);
        return count;
    }
}
