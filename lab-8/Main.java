class DisplayThread extends Thread {
    String message;
    int delay;

    DisplayThread(String message, int delay) {
        this.message = message;
        this.delay = delay;
    }

    public void run() {
        try {
            while (true) {
                System.out.println(message);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DisplayThread t1 = new DisplayThread("BMS College of Engineering", 10000);
        DisplayThread t2 = new DisplayThread("CSE", 2000);

        t1.start();
        t2.start();
    }
}
