/**
 * A thread generates n random integer numbers and writes them into a shared memory with a capacity of m integers
 * @author 689591
 */
public class ThreadA extends Thread{
    private SharedClass sharedLocal;

    /**
     * Create the thread and give access to share memory
     * @param LocalValue the share memory
     */
    public ThreadA(SharedClass LocalValue) {
        sharedLocal = LocalValue;
    }

    public void run() {
        //loop until n random integer numbers generated
        while (sharedLocal.getGenerated() < sharedLocal.getN()) {
            try {
                sharedLocal.generateRandom();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        sharedLocal.end();
        System.out.println("A END");
    }
}
