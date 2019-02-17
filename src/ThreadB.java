import java.io.IOException;

/**
 * A thread read the integer  numbers from shared memory and writes even numbers to file even-number.txt
 * @author 689591
 */
public class ThreadB extends Thread {
    private SharedClass sharedLocal;

    /**
     * Create the thread and give access to shared memory
     * @param LocalValue the shared memory
     */
    public ThreadB(SharedClass LocalValue) {
        sharedLocal = LocalValue;
    }

    public void run() {
        //loop until all numbers generated and filtered
        while (!(sharedLocal.isEnd() && sharedLocal.getArraySize() == 0)) {
            try {
                sharedLocal.filterEven();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("B END");
    }

}
