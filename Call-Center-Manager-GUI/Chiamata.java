public class Chiamata{

    Operatore operatore;

    /*Stringhe CLASSE CHIAMATA*/

    private String numero;

    /*Int CLASSE CHIAMATA*/

    private String destinatario;


    private int giorno;
    private int mese;
    private int anno;
    private int ora;
    private int minuti;

    /*Boolean CLASSE CHIAMATA*/


    public Chiamata(String id, boolean esito , String numero, String destinatario, int ora, int minuti, int giorno, int mese, int anno){
        operatore = new Operatore(id,esito);
        setDestinatario(destinatario);
        setNumero(numero);
        setOra(ora);
        setMinuti(minuti);
        setGiorno(giorno);
        setMese(mese);
        setAnno(anno);
    }
    

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getGiorno() {
        return this.giorno;
    }

    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }

    public int getMese() {
        return this.mese;
    }

    public void setMese(int mese) {
        this.mese = mese;
    }

    public int getAnno() {
        return this.anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getOra() {
        return this.ora;
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public int getMinuti() {
        return this.minuti;
    }

    public void setMinuti(int minuti) {
        this.minuti = minuti;
    }

    public String getDestinatario() {
        return this.destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }    


    public String toString(){
        String s=("Operatore:"+operatore.getId()+"\nEsito: "+operatore.isEsito()+" Numero:"+getNumero()+"\nDestinatario"+getDestinatario()+"\nOrario: "+getOra()+":"+getMinuti()+"\nData: "+getGiorno()+"/"+getMese()+"/"+getAnno()+"\n");
        return s;
    }
    
    public String toCsv(){
        String s=""+operatore.getId()+","+operatore.isEsito()+","+getNumero()+","+getDestinatario()+","+getOra()+":"+getMinuti()+","+getGiorno()+"/"+getMese()+"/"+getAnno()+"\n";
        return s;        

    }
}
