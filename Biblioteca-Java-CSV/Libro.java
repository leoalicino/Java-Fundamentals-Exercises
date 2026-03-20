public class Libro {

    /**Attributi Oggetto Libro**/

    private String autore;
    private String titolo;
    private int pagine;
    private boolean prestato;

    public Libro(String autore,String titolo,int pagine, boolean prestato){
        this.autore=autore;
        this.titolo=titolo;
        this.pagine=pagine;
        this.prestato=prestato;
    }

    /**Set and Get Oggetto Libro**/

    public String getAutore() {
        return this.autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getPagine() {
        return this.pagine;
    }

    public void setPagine(int pagine) {
        this.pagine = pagine;
    }

    public boolean isPrestato() {
        return this.prestato;
    }

    public void setPrestato(boolean prestato) {
        this.prestato = prestato;
    }

    /**ToString /ToCSV**/

    public String toString(){
        return "Autore: "+getAutore()+"\nTitolo: "+getTitolo()+"\nPagine: "+getPagine()+"\nPrestato: "+(isPrestato()? "In Prestito":"Non in Prestito")+"\n";
    }

    public String toCSV(){
        return ""+getAutore()+","+getTitolo()+","+getPagine()+","+isPrestato()+"\n";
    }

    
}
