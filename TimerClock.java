public class TimerClock implements Runnable {

    private final int durationInSeconds;

    TimerClock(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public void run() {
        int remaining = durationInSeconds;

        while (remaining >= 0) {
            int hours = remaining / 3600;
            int minutes = (remaining % 3600) / 60;
            int seconds = remaining % 60;

            System.out.printf("\r%02d:%02d:%02d", hours, minutes, seconds);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Timer interrupted");
            }

            remaining--;
        }

        System.out.println("\n***TIMER ENDED***");
    }
}
