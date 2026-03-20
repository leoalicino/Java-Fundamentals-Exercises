public class Pilota {
    private String nome;

    public Pilota() {
        this.nome = "";
    }

    public void setNome() {
        do {
            nome = Funzioni.leggiStringa("Inserisci nome pilota (max 18): ");
        } while (nome.length() > 18);
    }

    public String getNome() {
        return nome;
    }
}