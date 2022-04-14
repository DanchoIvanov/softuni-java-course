package listy_iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ListyIterator implements Iterable<String> {
    private List<String> list;

    private String get(int index){
        return list.get(index);
    }

    public void create (String... elements){
        this.list = Arrays.stream(elements).collect(Collectors.toList());
    }

    @Override
    public Iterator<String> iterator() {
        return new ListyyIterator();
    }

    private int count = 0;

    public boolean hasNext() {
        return count < list.size()-1;
    }

    public boolean move(){
        if (hasNext()){
            count++;
            return true;
        }
        return false;
    }

    public String get() {
        if (list.size() > 0) {
            return list.get(count);
        } else {
            return "Invalid Operation!";
        }
    }

    private class ListyyIterator implements Iterator<String> {
        private int count = 0;

        @Override
        public boolean hasNext() {
            return count < list.size();
        }

        @Override
        public String next() {
            return list.get(count++);
        }
    }
}


