public class Pallinometro{
  
    File file = new File();

    /*Dichiarazione Variabili e Costanti*/  
  
    private final int RIGHE=12;            /*COSTANTE --> numero righe (d)*/  
    private final int CASELLE=RIGHE+1;     /*COSTANTE --> numero caselle*/  
    private final int PRIMEDIECI=10;       /*COSTANTE --> primi dieci lanci*/ 
  
  
    private int finalSlot;   
    private int direzione;    
    private int contatore;    
    private int contatore1;   
    private int dxcounter;   
    private int nPalline;
  
    private String s[]= new String [10];                 /*ARRAY --> Tiene conto degli spostamenti delle prime dieci palline*/  
    private int []risultati = new int [CASELLE];         /*ARRAY --> Tiene conto delle caselle finali di ogni pallina*/  
    

    /**
     * 
     * @param n Intero --> Numero palline da lanciare
     */
    public Pallinometro(int n){
      this.setPalline(n);  
      this.inizializza();
    }

    public void lancioPalline()
    {
      for(int index=0;index<getPalline();index++){ 
        contatore++;
        finalSlot=1;  
        for(int j=0;j<RIGHE;j++){  
        contatore1++;
          this.direzione=1+(int)Math.floor(Math.random()*2); /*RANDOM --> Genera tra [1] e [2], 1-->SX; 2--> DX.*/
  
          urtoPalline(direzione); 
        }
      risultati[finalSlot-1]++; 
      }
    }  
  
    /**
     * 
     * @param d Intero --> Direzione
     */
    private void urtoPalline(int d){
      if(d==1){  /**Sinistra */
        if(contatore<=PRIMEDIECI){
          s[contatore-1]+="S|"; 
          if(contatore1==RIGHE){
            contatore1=0;
            s[contatore-1]+=" ---> "+finalSlot;          
          }       
        }
      }    
      
      if(d==2){  /**Destra */
        finalSlot++;
        dxcounter++;
        if(contatore<=PRIMEDIECI){
          s[contatore-1]+="D|"; 
          if(contatore1==RIGHE){
            contatore1=0;
            s[contatore-1]+=" ---> "+finalSlot;
            
          }                
        }
      }
    }  
  
    public String stampaStatistiche(){
      String aux="";    
      for(int index=0;index<CASELLE;index++){
        aux+=("\n--------====--====--------\n|    Casella  --[ "+(index+1)+" ]--\n|      Palline : "+(risultati[index])+" ");
      }
      aux+=("\n\n--------------------------------------------\n|LA PALLINA HA URTATO VERSO DESTRA "+(dxcounter)+" VOLTE |\n--------------------------------------------");
      return aux;
    }
    
    public String stampaSequenza(){    
      String aux="";  
      for(int index=0;index<PRIMEDIECI;index++){
        aux+=("---== Lancio N. "+(index+1)+":\t"+(s[index])+"\n");

      }
      return aux;
    }

    private void inizializza(){
      for(int index=0;index<CASELLE;index++){  
        risultati[index]=0;
        if(index<PRIMEDIECI){   
          s[index]="";            
        }
      }
    }

    /**
     * 
     * @param n  Intero che rappresenta il numero di Palline
     */
    private void setPalline(int n){
        nPalline=n;
      } 
    
      public int getPalline(){
        return nPalline;
      }
    
      public int getCaselle(){
        return CASELLE;
      }

      /**
       * 
       * @param i Intero che rappresenta la cella del vettore
       * @return
       */
      public int getArray(int i){
        return risultati[i];
      }    
}  