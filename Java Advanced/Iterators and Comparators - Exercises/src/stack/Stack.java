package stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack implements Iterable<Integer>{
    private List<Integer> list;

    public Stack() {
        this.list = new ArrayList<>();
    }

    public void push(int... elements){
        for (int i = 0; i < elements.length; i++) {
            list.add(elements[i]);
        }
    }

    public Integer pop() {
        if (list.size() > 0) {
            return list.remove(list.size() - 1);
        } else {
            return null;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Integer> {
        int count = list.size()-1;

        @Override
        public boolean hasNext() {
            return count >= 0;
        }

        @Override
        public Integer next() {
            return list.get(count--);
        }
    }
}
