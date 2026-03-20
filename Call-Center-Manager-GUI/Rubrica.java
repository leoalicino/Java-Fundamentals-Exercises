import java.util.*;
import java.io.*;

public class Rubrica{

    private final String nomeFile = "Registro.csv";
    Operatore operatore;
    Vector<Operatore> vett;


    public Rubrica(){
        vett = new Vector<Operatore>();
    }


    public void addChiamata(Chiamata call){
        File.scriviFile(nomeFile, call.toCsv(), true);
    }

    public String csvToString(){
        String letturaFile="";
        String temp[] = new String [6];
        BufferedReader leggiriga = File.apriFileLettura(nomeFile);
        String leggi="";
        try{
            leggi=leggiriga.readLine();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        try{
            while(leggi!=null){
                temp=leggi.split(",",6);

                leggi=leggiriga.readLine();
                letturaFile+="\n\n"; 
                letturaFile+="\nOperatore : "+temp[0]+"";  
                letturaFile+="\nEsito : "+(Boolean.parseBoolean(temp[1])? "Positivo":"Negativo")+"";  
                letturaFile+="\nNumero : "+temp[2]+"";  
                letturaFile+="\nDestinatario : "+temp[3]+"";  
                letturaFile+="\nOrario : "+temp[4]+"";  
                letturaFile+="\nData : "+temp[5]+"";         
            }   
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return letturaFile;
    }

    public void incrementaEsito(Operatore ope){
        ope.setChiamatePositive(ope.getChiamatePositive()+1);
    }

    public void leggiOperatori(){
        String temp[] = new String [6];
        BufferedReader leggiriga = File.apriFileLettura(nomeFile);
        String leggi="";
        try{
            leggi=leggiriga.readLine();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        try{
            while(leggi!=null){
                temp=leggi.split(",",6);
                leggi=leggiriga.readLine(); 
                gestisciOperatori(temp[0], Boolean.parseBoolean(temp[1]));                      
            }      
        }catch(IOException e){
            System.out.println(e.getMessage());
        }        
    }

    private void gestisciOperatori(String id, boolean esito){
        boolean trovato=false;
        if(vett.size()==0){
            vett.addElement(operatore = new Operatore(id,esito));
            if(esito) vett.elementAt(0).setChiamatePositive(operatore.getChiamatePositive()+1);
            return;
        }
        for(int index=0;index<vett.size();index++){
            if(id.equals(vett.elementAt(index).getId())){
                trovato=true;
                if(esito){
                    int x=vett.elementAt(index).getChiamatePositive();
                    vett.elementAt(index).setChiamatePositive(x+1);
                }
            }
        }
        if(!trovato){
            vett.addElement(operatore = new Operatore(id,esito));
            if(esito) vett.elementAt(vett.size()-1).setChiamatePositive(operatore.getChiamatePositive()+1);

        }   
    }  

    public String getBestOperatore(){
        leggiOperatori();
        int pos=0;
        int max=vett.elementAt(0).getChiamatePositive();
        for(int index=0;index<vett.size();index++){
            if(max<=vett.elementAt(index).getChiamatePositive()){
                max=vett.elementAt(index).getChiamatePositive();
                pos=index;       
            }
        }
        return vett.elementAt(pos).toString();
        
    }
}
