import java.io.*;

public class Funzioni {
    public static String leggiStringa(String sms) {
        System.out.print(sms);
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        try {
            return tastiera.readLine();
        } catch (Exception e) {
            return "";
        }
    }

    public static int leggiIntero(String sms) {
        try {
            return Integer.parseInt(leggiStringa(sms));
        } catch (Exception e) {
            return -999;
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}