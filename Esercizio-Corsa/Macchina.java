public class Macchina {
    private int numeroMacchina;
    private String scuderia;
    private int punteggio;
    private final int MAXNUMEROMACCHINA = 99;
    Pilota driver = new Pilota();

    public Macchina() {
        this.scuderia = "";
        this.numeroMacchina = 0;
        this.punteggio = 0;
    }

    public void setScuderia() {
        System.out.println("\n1. Scuderie F1 esistenti\n2. Nome personalizzato");
        int opzioneScuderia = Funzioni.leggiIntero("");
        if (opzioneScuderia == 1) {
            System.out.println("1. Ferrari, 2. Mercedes...");
            int r = Funzioni.leggiIntero("");
            if (r == 1)
                scuderia = "Ferrari"; // Ecc...
        } else {
            scuderia = Funzioni.leggiStringa("Inserisci nome: ");
        }
    }

    public String getScuderia() {
        return scuderia;
    }

    public void setNumero() {
        numeroMacchina = Funzioni.leggiIntero("Inserisci numero (1-99): ");
    }

    public int getNumero() {
        return numeroMacchina;
    }

    public void setPilota() {
        driver.setNome();
    }

    public void setPoints() {
        this.punteggio += 5 + (int) Math.floor(Math.random() * 56);
    }

    public int getPoints() {
        return punteggio;
    }

    public String toString() {
        return "Pilota: " + driver.getNome() + " | Scuderia: " + scuderia + " | Punti: " + punteggio;
    }
}