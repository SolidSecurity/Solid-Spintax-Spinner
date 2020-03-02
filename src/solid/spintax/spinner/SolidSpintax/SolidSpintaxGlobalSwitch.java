package solid.spintax.spinner.SolidSpintax;

import java.util.HashMap;

public class SolidSpintaxGlobalSwitch extends SolidSpintaxSwitch implements SolidSpintaxElement {

    private String result;
    public static HashMap<String, SolidSpintaxGlobalSwitch> switches = new HashMap<String, SolidSpintaxGlobalSwitch>();
    private SolidSpintaxGlobalSwitch master;

    public SolidSpintaxGlobalSwitch() {
        super();
    }

    public void setMaster(SolidSpintaxGlobalSwitch master) {
        this.master = master;
    }

    @Override
    public String spin(int tag) {
        if (master == null) {
            this.result = super.spin(tag);
            return result;
        } else {
            return master.result;
        }
    }

    @Override
    public String toString() {
        return "@" + super.toString();
    }

    @Override
    public int countPermutations() {
        if (master == null) {
            return super.countPermutations();
        } else {
            return 1;
        }
    }
}
