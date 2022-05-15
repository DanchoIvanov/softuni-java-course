package implementations;

import org.junit.Test;

import static org.junit.Assert.*;


public class ReversedListTest {

    @Test
    public void testReversedListGrow() {
        ReversedList<Integer> list = new ReversedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(list.removeAt(5));
        System.out.println();
    }

}
