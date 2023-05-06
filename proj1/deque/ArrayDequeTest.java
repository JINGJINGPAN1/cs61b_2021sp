package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addIsEmptySizeTest() {

        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();

        assertTrue("A newly initialized ArrayDeque should be empty", ad.isEmpty());
        ad.addFirst(12);

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, ad.size());
        assertFalse("ad should now contain 1 item", ad.isEmpty());

        ad.addLast(13);
        assertEquals(2, ad.size());

        ad.addLast(14);
        assertEquals(3, ad.size());

        System.out.println("Printing out deque: ");
        ad.printDeque();
    }

    @Test
    public void addRemoveTest(){
        ArrayDeque<Integer> ad1= new ArrayDeque<Integer>();
        assertTrue("A newly initialized ArrayDeque should be empty", ad1.isEmpty());
        ad1.addFirst(1);
        assertEquals(1, ad1.size());
        ad1.removeFirst();
        assertEquals(0,ad1.size());
        ad1.addLast(2);
        ad1.addLast(3);
        assertEquals(2, ad1.size());
        ad1.removeLast();
        assertEquals(1, ad1.size());
        System.out.println("Printing out deque: ");
        ad1.printDeque();
    }


    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        ArrayDeque<Integer> ad2 = new ArrayDeque<Integer>();
        ad2.addFirst(3);
        ad2.addFirst(5);
        ad2.addLast(4);
        ad2.addLast(6);

        ad2.removeLast();
        ad2.removeFirst();
        ad2.removeFirst();
        ad2.removeLast();


        int size = ad2.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {

        ArrayDeque<String>  ad11 = new ArrayDeque<String>();
        ArrayDeque<Double>  ad12 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> ad13 = new ArrayDeque<Boolean>();

        ad11.addFirst("string");
        ad12.addFirst(3.14159);
        ad13.addFirst(true);

        String s = ad11.removeFirst();
        double d = ad12.removeFirst();
        boolean b = ad13.removeFirst();

    }

    @Test
    public void emptyNullReturnTest() {

        ArrayDeque<Integer> ad21 = new ArrayDeque<>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, ad21.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, ad21.removeLast());

    }


}
