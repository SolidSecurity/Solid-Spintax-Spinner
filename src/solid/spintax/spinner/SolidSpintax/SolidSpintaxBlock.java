package solid.spintax.spinner.SolidSpintax;

import java.util.ArrayList;

public class SolidSpintaxBlock implements SolidSpintaxElement {

    private final ArrayList<SolidSpintaxElement> body;

    public SolidSpintaxBlock() {
        body = new ArrayList<>();
    }

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
