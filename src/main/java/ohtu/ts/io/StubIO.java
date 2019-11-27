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
        if (i < inputs.size()) {
            return inputs.get(i++);
        }
        return "";
    }
    
    public String getOutputAt(int i) {
        if (i < 0) {
            return "out of boundaries";
        } else {
            return outputs.get(i);
        }
    }
    
    public int lastOutputIndex() {
        return outputs.size() - 1;
    }
}
