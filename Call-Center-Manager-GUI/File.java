import java.io.*;

public class File{

  //File
  static FileWriter f;
  static PrintWriter fOUT;
  static FileReader f1;
  static BufferedReader fIN;
  
  public static void scriviFile(String nome, String testo, boolean append){
    try{
      f = new FileWriter(nome,append);
      fOUT= new PrintWriter(f);
      fOUT.print(testo);  
      f.close();    
    }catch(IOException e){
      System.out.println(e.getMessage());
    }
  }  

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
  public static BufferedReader apriFileLettura(String nomeFile){
    try{
      f1 = new FileReader(nomeFile);
      fIN = new BufferedReader(f1);
    }catch(IOException e){
      System.out.println("\nEccezione: "+ e.getMessage());
    }
    return fIN;
  }

  public void clearFile(String name){
    try{
      f = new FileWriter(name,false);
      fOUT= new PrintWriter(f);
      fOUT.print("");  
      f.close();    

    }
      
    catch(Exception e){
      System.out.println(e);
    }    
  }  
}
