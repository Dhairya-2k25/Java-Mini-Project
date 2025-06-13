import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Alarmy !");
        System.out.println("1. Set Alarm");
        System.out.println("2. Set Timer");

        System.out.print("Choose option (1 or 2): ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime alarmTime = null;

            while (alarmTime == null) {
                try {
                    System.out.print("Enter an alarm time (HH:mm:ss): ");
                    String inputTime = sc.nextLine();
                    alarmTime = LocalTime.parse(inputTime, formatter);
                    System.out.println("Alarm Set for: " + alarmTime);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid format. Use HH:mm:ss");
                }
            }

            AlarmCLock alarmCLock = new AlarmCLock(alarmTime);
            Thread alarmThread = new Thread(alarmCLock);
            alarmThread.start();
        }

        else if (choice == 2) {
            int hours, minutes, seconds;

            System.out.print("Enter hours (HH): ");
            hours = sc.nextInt();
            System.out.print("Enter minutes (mm): ");
            minutes = sc.nextInt();
            System.out.print("Enter seconds (ss): ");
            seconds = sc.nextInt();
            sc.nextLine();

            int totalSeconds = hours * 3600 + minutes * 60 + seconds;

            if (totalSeconds <= 0) {
                System.out.println("Duration must be greater than 0.");
                return;
            }

            TimerClock timer = new TimerClock(totalSeconds);
            Thread timerThread = new Thread(timer);
            timerThread.start();
        }

        else {
            System.out.println("Invalid choice.");
        }
    }
}
