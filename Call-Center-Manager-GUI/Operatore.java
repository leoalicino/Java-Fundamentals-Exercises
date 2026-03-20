public class Operatore{
    public String id;
    public boolean esito;
    public int chiamatePositive;


    public Operatore(String id, boolean esito){
        setId(id);
        setEsito(esito);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isEsito() {
        return this.esito;
    }

    public void setEsito(boolean esito) {
        this.esito = esito;
    }

    public int getChiamatePositive() {
        return this.chiamatePositive;
    }

    public void setChiamatePositive(int callPos) {
        this.chiamatePositive = callPos;
    }

    public String toString(){
        return "Id :"+getId()+"\nEsiti Positivi :"+getChiamatePositive()+"";
    }


    
    
}
