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
    private List<String> outputs;

    public StubIO(List<String> inputs) {
        this.i = 0;
        this.inputs = inputs;
        this.outputs = new ArrayList<>();
    }

    @Override
    public void print(String text) {
        outputs.add(text);
    }

    public List<String> getOutputs() {
        return outputs;
    }

    @Override
    public String readLine(String text) {
        print(text);
        return inputs.get(i++);
    }
}
