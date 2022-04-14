package stack_of_string;

import java.util.List;

public class StackOfStrings {

    private List<String> data;

    public void push(String string) {
        this.data.add(string);
    }

    public String pop() {
        return this.data.remove(this.data.size()-1);
    }

    public String peek() {
        return this.data.get(this.data.size()-1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }


}
