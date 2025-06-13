import java.time.LocalTime;

public class AlarmCLock implements Runnable {

    private final LocalTime alarmTime;

    AlarmCLock(LocalTime alarmTime) {
        this.alarmTime = alarmTime;
    }

    public void run() {
        while (true) {
            LocalTime now = LocalTime.now();

            if (!now.isBefore(alarmTime)) {
                break;
            }

            try {
                int hours = now.getHour();
                int minutes = now.getMinute();
                int seconds = now.getSecond();

                System.out.printf("\r%02d:%02d:%02d", hours, minutes, seconds);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread was Interrupted");
            }
        }

        System.out.println("\n***ALARM NOISE***");
    }
}
