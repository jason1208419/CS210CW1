public class HelloThread extends Thread{
    public void run() {
        System.out.println("Hello");
    }
    public static void main(String[] Arg) {
        //HelloThread helloThread = new HelloThread();
        Thread thread = new HelloThread();
        thread.start();
    }
}
