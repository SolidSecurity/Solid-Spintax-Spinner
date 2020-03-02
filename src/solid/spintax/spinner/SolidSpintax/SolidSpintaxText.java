package solid.spintax.spinner.SolidSpintax;

public class SolidSpintaxText implements SolidSpintaxElement {

    private String body;

    public SolidSpintaxText(String body) {
        this.body = body;
    }

    @Override
    public String spin(int tag) {
        if (tag != 0) {
            System.out.print("SolidStrSwitch tag is not 0");
        }
        return body;
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < body.length(); i++) {
            char curr = body.charAt(i);
            if (curr == '@' || curr == '|' || curr == '{' || curr == '}' || curr == '\\') {
                out += '\\';
            }
            out += curr;
        }
        return out;
    }

    @Override
    public int countPermutations() {
        return 1;
    }

    @Override
    public int countSwitches() {
        return 0;
    }
}
