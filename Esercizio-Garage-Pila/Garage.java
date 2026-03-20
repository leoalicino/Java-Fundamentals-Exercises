public class Garage{

  private Pila pila;  

  private String nomeAuto;  //Nome da Attribuire all'auto.


  public Garage()
  {
    pila = new Pila(); //Creazione Istanza Pila.
    this.nomeAuto="";  //Inizializzo Il nome dell'Auto.
  }


  public void entrata()  //Metodo per Aggiungere Macchine Al Garage.
  {
    System.out.println("Inserisci il nome  dell'auto ");
    nomeAuto=Funzioni.leggiStringa("");

    pila.push(nomeAuto);  //Push.
      
  }

  public void uscita(){  //Metodo che fa avvennire l'Uscita della Ultima Macchina.
    System.out.println("È Uscita la macchina: ");
    System.out.println(pila.pop());        
  }

  public void exitAll(){  //Metodo che fa uscire tutte le Macchine == PILA VUOTA.
    int size=pila.size();
    if (pila.vuota()){
      System.out.println("Pila Vuota");
    }
    else{
      System.out.println("\nUscita di tutte le macchine: ");
      for (int i=0;i<size;i++){
        System.out.println(pila.pop());
      }
      System.out.println("Pila Svuotata");
    }      
  }

  public void stampaPila(){  //Metodo che stampa La Pila.
    System.out.println("\nLe macchine presenti nel garage sono queste:");
    pila.stampa();
  }




  



}