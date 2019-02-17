import java.io.IOException;

/**
 * The main method to run threads
 */
public class Main {
    public static void main(String[] Arg) throws InterruptedException, IOException {
        //The filtering is into k files (only choose 2 or 3)
        int k = 4;
        SharedClass MySharedClass = new SharedClass(4, 80);

        Thread threadA = new ThreadA(MySharedClass);
        Thread threadB = new ThreadB(MySharedClass);
        Thread threadC = new ThreadC(MySharedClass);
        Thread threadD = new ThreadD(MySharedClass);

        MySharedClass.clearFile("even-number.txt");
        MySharedClass.clearFile("odd-number.txt");
        MySharedClass.clearFile("multiples-of-3.txt");

        if (k>=2) {
            threadA.start();
            threadB.start();
            threadC.start();
        }
        if (k>=3) {
            threadD.start();
        }


        if (k>=2) {
            threadA.join();
            threadB.join();
            threadC.join();
        }
        if (k>=3) {
            threadD.join();
        }

        System.out.println("End");
    }
}
