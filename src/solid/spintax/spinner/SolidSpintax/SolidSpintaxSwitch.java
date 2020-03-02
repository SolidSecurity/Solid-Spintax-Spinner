package solid.spintax.spinner.SolidSpintax;

import java.util.ArrayList;

public class SolidSpintaxSwitch implements SolidSpintaxElement {

    private final ArrayList<SolidSpintaxElement> children;
    private final int switches = 0;

    public SolidSpintaxSwitch() {
        children = new ArrayList<>();
    }

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
