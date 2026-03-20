class Main {
    public static void main(String[] args) {
        Gara corsa = new Gara();
        boolean ripeti = true;
        int menu;
        int continuare = 0;

        while (ripeti) {
            ripeti = false;

            corsa.presentazione();
            corsa.setPista();
            corsa.setGiri();
            corsa.setPartecipanti();
            corsa.creaGriglia();
            corsa.corsa();
            corsa.ordina();

            do {
                continuare = 0;
                System.out.println(
                        "\nCosa vorresti fare?\n1. Mostra i punteggi di ogni giro;\n2. Mostra la classifica finale;\n3. Cerca un pilota;\n4. Visualizza il podio;\n5. Ripeti il programma;\n6. Termina il programma.");
                menu = Funzioni.leggiIntero("");

                switch (menu) {
                    case 1:
                        Funzioni.clearScreen();
                        System.out.println("\n-------- RISULTATI --------");
                        corsa.ogniGiro();
                        System.out.println("\n-------- VUOI CONTINUARE? --------\n1. Sì;\n2. No.");
                        continuare = Funzioni.leggiIntero("");
                        if (continuare != 1)
                            System.exit(0);
                        break;
                    case 2:
                        Funzioni.clearScreen();
                        System.out.println("\n-------- CLASSIFICA --------");
                        corsa.classifica();
                        System.out.println("\n-------- VUOI CONTINUARE? --------\n1. Sì;\n2. No.");
                        continuare = Funzioni.leggiIntero("");
                        if (continuare != 1)
                            System.exit(0);
                        break;
                    case 3:
                        Funzioni.clearScreen();
                        corsa.trovaGiocatore();
                        System.out.println("\n-------- VUOI CONTINUARE? --------\n1. Sì;\n2. No.");
                        continuare = Funzioni.leggiIntero("");
                        if (continuare != 1)
                            System.exit(0);
                        break;
                    case 4:
                        Funzioni.clearScreen();
                        System.out.println("\n-------- PODIO --------");
                        corsa.podio();
                        System.out.println("\n-------- VUOI CONTINUARE? --------\n1. Sì;\n2. No.");
                        continuare = Funzioni.leggiIntero("");
                        break;
                    case 5:
                        Funzioni.clearScreen();
                        ripeti = true;
                        break;
                    case 6:
                        Funzioni.clearScreen();
                        System.out.println("\nChiudendo...");
                        System.exit(0);
                        break;
                    default:
                        Funzioni.clearScreen();
                        System.out.println("\n-------- NUMERO ERRATO! --------");
                        System.exit(0);
                }
            } while (continuare == 1);
        }
    }
}