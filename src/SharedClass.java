import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * The shared memory
 * @author 689591
 */
public class SharedClass {
    private int m;
    private int n;
    private int arraySize = 0;
    private int generated = 0;
    private int[] SharedValue;

    private boolean end = false;

    private Random rand = new Random();

    /**
     * Create a share memory
     */
    public SharedClass() {
        this.m = 4;
        this.n = m * 100;
        this.SharedValue = new int[m];
        Arrays.fill(this.SharedValue, -1);
    }

    /**
     * Create a share memory
     * @param m The size of the local storage capacity
     * @param n The size of the data
     */
    public SharedClass(int m, int n) {
        this.m = m;
        this.n = n;
        this.SharedValue = new int[m];
        Arrays.fill(this.SharedValue, -1);
    }

    /**
     * Generate number if the local storage is not full
     * @throws InterruptedException wait()
     */
    public synchronized void generateRandom() throws InterruptedException {
        //wait until there is free space in local storage
        if (arraySize == m) {
            System.out.println("I'm waiting for you to filter!");
            wait();
        //generate a number
        } else {
            //loop though the local storage to find a free space
            for (int i = 0; i < m; i++) {
                //if a free space (-1) is found and write a number to it
                if (SharedValue[i] == -1) {
                    SharedValue[i] = rand.nextInt(Integer.MAX_VALUE);
                    arraySize++;
                    generated++;
                    return;
                }
            }
        }
    }

    /**
     * Change boolean to true after all numbers generated
     */
    public synchronized void end() {
        end = true;
    }

    /**
     * Find the even numbers and add to a array list
     */
    public synchronized void filterEven() throws IOException {
        //loop though the local storage to find even numbers
        for (int i = 0; i < m; i++) {
            //if an even number is found, add it to an array list
            if (SharedValue[i] % 2 == 0 && SharedValue[i] != -1) {
                writeToFile("even-number.txt", SharedValue[i]);
                System.out.println(SharedValue[i] + ": even");
                SharedValue[i] = -1;
                arraySize--;
                notifyAll();
            }
        }
    }

    /**
     * Find the odd numbers and add to a array list
     */
    public synchronized void filterOdd() throws IOException {
        //loop though the local storage to find odd numbers
        for (int i = 0; i < m; i++) {
            //if an odd number is found, add it to an array list
            if (SharedValue[i] % 2 != 0 && SharedValue[i] != -1) {
                writeToFile("odd-number.txt", SharedValue[i]);
                System.out.println(SharedValue[i] + ": odd");
                SharedValue[i] = -1;
                arraySize--;
                notifyAll();
            }
        }
    }

    /**
     * Find the multiples of 3 and add to a array list
     */
    public synchronized void filterMulti3() throws IOException {
        //loop though the local storage to find multiples of 3
        for (int i = 0; i < m; i++) {
            //if a multiples of 3 is found, add it to an array list
            if (SharedValue[i] % 3 == 0 && SharedValue[i] != -1) {
                writeToFile("multiples-of-3.txt", SharedValue[i]);
                System.out.println(SharedValue[i] + ": multiples of 3");
                SharedValue[i] = -1;
                arraySize--;
                notifyAll();
            }
        }
    }

    /**
     * Get the number of occupied space in the array
     * @return the number of occupied space
     */
    public int getArraySize() {
        return arraySize;
    }

    /**
     * Get the number of number generated
     * @return the number of number generated
     */
    public int getGenerated() {
        return generated;
    }

    /**
     * Get the status to see if all numbers generated
     * @return the boolean
     */
    public boolean isEnd() {
        return end;
    }

    /**
     * Get the size of the data (n)
     * @return n
     */
    public int getN() {
        return n;
    }

    /**
     * If the file already exists, empty it
     * @param fileName the file name of the file to be output
     * @throws IOException output error
     */
    public void clearFile (String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write("");
        writer.close();
    }

    /**
     * Output an array list to file
     * @param fileName the file name of the file to be output
     * @param number the filtered number to be written into file
     * @throws IOException output error
     */
    public void writeToFile (String fileName, int number) throws IOException {
        FileWriter writer = new FileWriter(fileName, true);
        writer.write(number + "\r\n");
        writer.close();
    }
}
