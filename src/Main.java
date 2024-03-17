import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        TimerThread timerThread = new TimerThread();
        timerThread.start();

        JOptionPane.showMessageDialog(null, "Timer started. Click OK to stop.");

        timerThread.interrupt();
    }

    private static class TimerThread extends Thread {
        private int seconds = 0;

        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    Thread.sleep(1000);
                    seconds++;
                    System.out.println("Timer: " + seconds + " seconds");
                }
            } catch (InterruptedException e) {
                System.out.println("Timer stopped.");
            }
        }
    }
}

