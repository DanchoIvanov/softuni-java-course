package froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private List<Integer> list;

    public Lake() {
        this.list = new ArrayList<>();
    }

    public void add(int... elements){
        for (int i = 0; i < elements.length; i++) {
            list.add(elements[i]);
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {

        int count = 0;
        boolean finishedFirstRound = false;

        @Override
        public boolean hasNext() {
            if (count >= list.size() && !finishedFirstRound) {
                if (list.size() < 2){
                    return false;
                }
                count = 1;
                finishedFirstRound = true;
                return true;
            };
            return count < list.size();
        }


        @Override
        public Integer next() {

            Integer number = list.get(count) ;
            count += 2;
            return number;
        }
    }
}
