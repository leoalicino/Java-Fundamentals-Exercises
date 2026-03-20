import java.io.*;

public class File{

  //File
  static FileWriter f;
  static PrintWriter fOUT;
  static FileReader f1;
  static BufferedReader fIN;
  

  /**
   * 
   * @param p  Istanza --> Passo l'istanza Pallinometro 
   * @param name Stringa --> Nome del File
   * @param append Boolean --> Append del File
   */
  public static void scriviFile(Pallinometro p,String name, boolean append){

    try{
      f = new FileWriter(name);
      fOUT= new PrintWriter(f);

      for (int index=0;index<p.getCaselle();index++){
      fOUT.print((index+1)+","+p.getArray(index)+"\n");
      }
     f.close();           
    }

    catch(Exception e){
      System.out.println(e);
    
    }
  }


  /**
   * 
   * @param nome Stringa --> Nome del file da leggere
   * @return Contenuto del file
   */
  public static String leggiFile(String nome){
    String salvaFile=null;
    String salvariga="";
    String temp="";
    
    try{
      f1 = new FileReader(nome);
      fIN = new BufferedReader(f1);                
      temp=fIN.readLine();
      while(temp!=null){
        salvariga=temp;
        temp=fIN.readLine();
        salvaFile+=salvariga+"\n";
      }
      f1.close();
    }catch(IOException e){
        System.out.println(e.getMessage());
    }
    return salvaFile;
  }
  
  //CopyRight @GiaCausa
  /**
   * 
   * @param nome Stringa --> Nome del file da aprire in lettura
   * @return Restituisce il Buffered
   */
  public static BufferedReader apriFileLettura(String nome){
    try{
      f1 = new FileReader(nome);
      fIN = new BufferedReader(f1);
    }catch(IOException e){
      System.out.println("\nEccezione: "+ e.getMessage());
    }
    return fIN;
  }
  
  /**
   * 
   * @param nome Stringa --> Nome del file da clearare
   */
  public static void clearFile(String nome){
    try{
      f = new FileWriter(nome,false);
      fOUT= new PrintWriter(f);
      fOUT.print("");  
      f.close();   
    }
      
    catch(Exception e){
      System.out.println(e);
    }    
  }  

  /**
   * 
   * @param nome Stringa --> Nome del file da convertire
   * @return Stringa --> Lettura del file 
   */
  public static String csvToString(String nome){

    String letturaFile="";
    String temp[] = new String [1];
    BufferedReader leggiriga = File.apriFileLettura(nome);
    String leggi="";

    try{
        leggi=leggiriga.readLine();
    }catch(IOException e){
        System.out.println(e.getMessage());
    }
    try{
        while(leggi!=null){
            temp=leggi.split(",",2);
            leggi=leggiriga.readLine();
            letturaFile+="---==---\n"; 
            letturaFile+="Casella N. "+temp[0]+"";  
            letturaFile+="\nNumero Palline  "+temp[1]+""; 
            letturaFile+="\n\n"; 

        }   
    }catch(IOException e){
        System.out.println(e.getMessage());
    }
    return letturaFile;
}
}

