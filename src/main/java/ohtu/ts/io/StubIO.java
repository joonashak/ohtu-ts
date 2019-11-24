package ohtu.ts.io;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ida
 */
public class StubIO implements IO {

    private List<String> inputs;
    private int i;
    private ArrayList<String> outputs;

    public StubIO(List<String> inputs) {
        this.inputs = inputs;
        this.outputs = new ArrayList<>();
    }

    public void print(String text) {
        outputs.add(text);
    }

    public ArrayList<String> getOutputs() {
        return outputs;
    }

    public String ReadLine(String text) {
        print(text);
        return inputs.get(i++);
    }
}