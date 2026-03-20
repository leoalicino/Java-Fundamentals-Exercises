import java.io.*;

public class Funzioni {

  // funzione che legge Stringhe in input
  public static String leggiStringa(String sms) {
    System.out.print(sms);
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader tastiera = new BufferedReader(in);
    try {
      return tastiera.readLine();
    } catch (Exception e) {
      System.out.println(e);
      return "";
    }
  }

  // funzione che legge Float in input
  public static float leggiFloat(String sms) {
    String letta = leggiStringa(sms);
    if (letta.equals("")) {
      return -99;
    }
    float valore;
    try {
      valore = Float.valueOf(letta).floatValue();
    } catch (Exception e) {
      System.out.println(e);
      System.out.println(
          "non è stato possibile convertire il valore, devi inserire un valore corretto. Hai inserito " + letta);
      return -98;
    }
    return valore;
  }

  // funzione che legge Interi in input
  public static int leggiIntero(String sms) {

    System.out.println(sms);
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader tastiera = new BufferedReader(input);
    String s;

    try {
      s = tastiera.readLine();
    } catch (Exception e) {
      System.out.println("\nEccezzione Rilevata!\nNumero non trovato\nChiusura programma in corso.");
      System.out.println(e);
      return -99999;
    }
    int n = 0;

    try {
      n = Integer.valueOf(s).intValue();
    } catch (Exception e) {
      System.out.println("\nEccezzione Rilevata!\nNumero non trovato\nChiusura programma in corso.");
      System.out.println(e);
      return -99998;
    }
    return n;
  }

  // funzione che pulisce lo schermo, elimininando tutto.
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

}