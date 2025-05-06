package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        BuggyAList<Integer> buglist = new BuggyAList<Integer>();
        AListNoResizing<Integer> correctlist = new AListNoResizing<Integer>();

        buglist.addLast(11);
        buglist.addLast(12);
        buglist.addLast(13);

        correctlist.addLast(11);
        correctlist.addLast(12);
        correctlist.addLast(13);

        assertEquals(correctlist.size(), buglist.size());

        assertEquals(correctlist.removeLast(), buglist.removeLast());
        assertEquals(correctlist.removeLast(), buglist.removeLast());
        assertEquals(correctlist.removeLast(), buglist.removeLast());




    }

    @Test
    public void testRandom(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                broken.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
                assertEquals(L.size(), broken.size());
            } else if (operationNumber == 1) {
                //getLast
                if(L.size()>0){
                    int last=L.getLast();
                    int lastB=broken.getLast();
                    //System.out.println("getLast(" + last + ")");
                    assertEquals(last, lastB);
                }
            }else if (operationNumber == 2){
                //removeLast
                if(L.size()>0){
                    int last=L.removeLast();
                    int lastB=broken.removeLast();
                    //System.out.println("removeLast(" + last + ")");
                    assertEquals(last, lastB);
                }
            }else{
                // size
                int size = L.size();
                int sizeB = broken.size();
                //System.out.println("size: " + size);
                assertEquals(size, sizeB);
            }
        }
    }

}
