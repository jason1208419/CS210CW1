import java.io.IOException;

/**
 * A thread read the integer  numbers from shared memory and writes multiples of 3 to file multiples-of-3.txt
 * @author 689591
 */
public class ThreadD extends Thread {
    private SharedClass sharedLocal;

    /**
     * Create the thread and give access to shared memory
     * @param LocalValue the shared memory
     */
    public ThreadD(SharedClass LocalValue) {
        sharedLocal = LocalValue;
    }

    public void run() {
        //loop until all numbers generated and filtered
        while (!(sharedLocal.isEnd() && sharedLocal.getArraySize() == 0)) {
            try {
                sharedLocal.filterMulti3();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("D END");
    }
}
