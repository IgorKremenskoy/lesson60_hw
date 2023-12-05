import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TarakanRace {
    static String winner = null;

    public static void main(String[] args) throws InterruptedException {
        int min = 2;
        int max = 5;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of tarakans: ");
        int numberOfTarakan = scanner.nextInt();

        System.out.print("Enter the number of iterations: ");
        int iterations = scanner.nextInt();

        Random random = new Random();
        int sleepTime = min + random.nextInt((max + 1) - min);

        System.out.println("Tarakans Race START!");

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            threads.add(new Thread(new Tarakan("Vasya-" + i, iterations, sleepTime)));        // input: (qtyTar, runCycles, sleepTime)
        }

        for (Thread thread : threads) {
            thread.start();
//            thread.join();

        }
        for (Thread thread : threads) {
//            thread.run();
            thread.join();

        }

        System.out.println("Tarakans Race FINISH!");
        System.out.println("Congratulations to tarakan #" + winner + "!  It's a winner!");
    }

    public static void setWinner(String tarakanNumber) {
        winner = winner == null ? tarakanNumber : winner;
    }
}
