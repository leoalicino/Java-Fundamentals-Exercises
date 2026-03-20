public class Gara {
    private int nGiri;
    private String mappa;
    private int nPiloti;
    private final int MAXPILOTI = 20;
    private final int MAXGIRI = 70;
    private final int PODIO = 3;
    Macchina auto = new Macchina();
    Macchina veicolo[];

    public Gara() {
        this.nGiri = 0;
        this.nPiloti = 0;
        this.mappa = "";
    }

    public void presentazione() {
        System.out.println("\n\n------------------------------ GARA GRAN PREMIO ------------------------------ \n Questo programma ti permetterà di gestire e vedere una gara automobilistica!");
    }

    public void setPartecipanti() {
        boolean errore1 = true;
        while (errore1) {
            errore1 = false;
            System.out.println("\n----- SCELTA NUMERO CONCORRENTI -----\nInserire un massimo di 20 piloti.");
            nPiloti = Funzioni.leggiIntero("Digita qui il numero dei piloti: ");
            if ((nPiloti < 2) || (nPiloti > MAXPILOTI)) {
                nPiloti = 0;
                Funzioni.clearScreen();
                System.out.println("\n-------- ALERTS! --------\nNumero piloti non valido!\n");
                errore1 = true;
            } else {
                vettore();
                Funzioni.clearScreen();
            }
        }
    }

    public int getPartecipanti() { return nPiloti; }

    public void setPista() {
        boolean errore2 = true;
        while (errore2) {
            errore2 = false;
            System.out.println("----- SCELTA PISTA -----\nInserisci il nome della pista (Massimo 20 caratteri).");
            mappa = Funzioni.leggiStringa("Digita qui il nome della tua pista: \n");
            if (mappa.length() > 14) {
                mappa = "";
                Funzioni.clearScreen();
                System.out.println("\n\n-------- ALERTS! --------\nNumero caratteri superati.\n");
                errore2 = true;
            } else {
                Funzioni.clearScreen();
            }
        }
    }

    public void setGiri() {
        boolean flag1 = true;
        while (flag1) {
            flag1 = false;
            nGiri = Funzioni.leggiIntero("Inserisci il numero di giri (max 70): ");
            if ((nGiri > 70) || (nGiri < 1)) {
                System.out.println("\n-------- ALERTS! --------\nNumero non valido!");
                flag1 = true;
            } else {
                Funzioni.clearScreen();
            }
        }
    }

    public int getGiri() { return nGiri; }

    public void vettore() {
        this.veicolo = new Macchina[nPiloti];
        for (int i = 0; i < nPiloti; i++) {
            veicolo[i] = new Macchina();
        }
    }

    public void creaGriglia() {
        for (int i = 0; i < veicolo.length; i++) {
            System.out.println("\nDettagli " + (i + 1) + "° Pilota:");
            do { veicolo[i].setScuderia(); } while (controlloScuderia(i) == 2);
            veicolo[i].setPilota();
            do { veicolo[i].setNumero(); } while (controlloNumero(i) == 1);
            Funzioni.clearScreen();
        }
    }

    public void corsa() {
        for (int i = 0; i < nGiri; i++) {
            for (int j = 0; j < veicolo.length; j++) {
                veicolo[j].setPoints();
            }
        }
    }

    public void ogniGiro() {
        for (int i = 0; i < nGiri; i++) {
            System.out.println("\n| " + (i + 1) + "° giro |");
            for (int j = 0; j < veicolo.length; j++) {
                veicolo[j].setPoints();
                System.out.println(veicolo[j].driver.getNome() + ": " + veicolo[j].getPoints() + " Punti.");
            }
        }
    }

    public void ordina() {
        boolean switcha;
        int y = veicolo.length - 1;
        do {
            switcha = false;
            for (int i = 0; i < y; i++) {
                if (veicolo[i].getPoints() < veicolo[i + 1].getPoints()) {
                    auto = veicolo[i];
                    veicolo[i] = veicolo[i + 1];
                    veicolo[i + 1] = auto;
                    switcha = true;
                }
            }
            y = y - 1;
        } while (switcha);
    }

    public void classifica() {
        for (int i = 0; i < veicolo.length; i++) {
            System.out.println("-------- " + (i + 1) + "° CLASSIFICATO --------- " + veicolo[i]);
        }
    }

    public void podio() {
        int limite = (getPartecipanti() < 3) ? veicolo.length : PODIO;
        for (int i = 0; i < limite; i++) {
            System.out.println("-------- " + (i + 1) + "° CLASSIFICATO --------- " + veicolo[i]);
        }
    }

    public void trovaGiocatore() {
        boolean ripetizione = true;
        while (ripetizione) {
            ripetizione = false;
            boolean nonTrovato = true;
            listaGiocatori();
            String ricerca = Funzioni.leggiStringa("").toLowerCase();
            int posizione = 0;
            for (int i = 0; i < veicolo.length; i++) {
                if (veicolo[i].driver.getNome().toLowerCase().equals(ricerca)) {
                    posizione = i;
                    nonTrovato = false;
                }
            }
            if (nonTrovato) {
                System.out.println("\nGiocatore inesistente!");
                // (Logica ripetizione omessa per brevità)
            } else {
                System.out.println("\nGiocatore trovato! Posizione: " + (posizione + 1));
            }
        }
    }

    public void listaGiocatori() {
        for (Macchina m : veicolo) System.out.println(" -> " + m.driver.getNome());
    }

    public int controlloScuderia(int verificaScuderia) {
        int conta = 0;
        for (int i = 0; i < verificaScuderia; i++) {
            if (veicolo[verificaScuderia].getScuderia().equals(veicolo[i].getScuderia())) conta++;
        }
        return conta;
    }

    public int controlloNumero(int verificaNumero) {
        int conta2 = 0;
        for (int i = 0; i < verificaNumero; i++) {
            if (veicolo[verificaNumero].getNumero() == veicolo[i].getNumero()) conta2++;
        }
        return conta2;
    }
}