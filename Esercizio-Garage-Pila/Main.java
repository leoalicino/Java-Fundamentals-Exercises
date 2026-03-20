class Main {
  public static void main(String[] args) {

    Garage garage = new Garage();

    boolean ripeti = false;
    int continuare = 1;

    do {

      int caso;

      while (continuare == 1) {
        System.out.println(
            "\nCosa Vuoi fare?\n1. Entrata di Una Macchina;\n2. Uscita dell'Ultima Macchina;\n3. Uscita di tutte le Macchine;\n4. Stampa Macchine nel garage;\n5. Uscita di una precisa Macchina;\n6. Termina il Programma;");

        caso = Funzioni.leggiIntero("");

        switch (caso) {

          case 1:
            Funzioni.clearScreen();
            garage.entrata();

            break;

          case 2:
            Funzioni.clearScreen();
            garage.uscita();

            break;

          case 3:
            Funzioni.clearScreen();
            garage.exitAll();

            break;

          case 4:
            Funzioni.clearScreen();
            garage.stampaPila();
            break;

          case 5:
            Funzioni.clearScreen();
            ripeti = true;
            break;

          case 6:
            Funzioni.clearScreen();
            System.exit(0);
            break;
        }
      }
    } while (ripeti);
  }
}