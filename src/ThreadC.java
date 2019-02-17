import java.io.IOException;

/**
 * A thread read the integer  numbers from shared memory and writes odd numbers to file odd-number.txt
 * @author 689591
 */
public class ThreadC extends Thread {
    private SharedClass sharedLocal;

    /**
     * Create the thread and give access to shared memory
     * @param LocalValue the shared memory
     */
    public ThreadC(SharedClass LocalValue) {
        sharedLocal = LocalValue;
    }

    public void run() {
        //loop until all numbers generated and filtered
        while (!(sharedLocal.isEnd() && sharedLocal.getArraySize() == 0)) {
            try {
                sharedLocal.filterOdd();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("C END");
    }
}
