import java.io.*;
import java.util.*;
public class Libreria {

    private Libro Libro;

    private final String nomefile = "bacheca.csv";
    private Vector<Libro> vett;

    public Libreria(){
        vett = new Vector<Libro>();
    }

    public void aggiungiLibro(Libro libro){
        File.scriviFile(nomefile, libro.toCSV(), true);
    }

    private void leggiCsv(){
        String temp[] = new String [4];
        String leggiriga="";
        BufferedReader lettore = File.apriFileLettura(nomefile);
        
        try{
            leggiriga=lettore.readLine();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        try{
            while(leggiriga!=null){
                temp=leggiriga.split(",",4);
                leggiriga=lettore.readLine();
                vett.add(new Libro(temp[0],temp[1],Integer.valueOf(temp[2]),Boolean.parseBoolean(temp[3])));                  
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        } 
    }

    public String cercaDaTitolo(String titolo){
        leggiCsv();
        int point=0;
        for(int index=0;index<vett.size();index++){
            if(vett.elementAt(index).getTitolo().equals(titolo)){
                point=index;
                break;
            }
        }
        return vett.elementAt(point).toString();
    }

    public String cercaDaAutore(String autore){
        leggiCsv();
        String s="Libro non trovato";
        for(int index=0;index<vett.size();index++){
            if(vett.elementAt(index).getAutore().equals(autore)){
                s=vett.elementAt(index).toString();
                break;
            }
        }
        return s;
    }    
 
}
