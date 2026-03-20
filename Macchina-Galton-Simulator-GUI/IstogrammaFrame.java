import javax.swing.*;
import java.io.*;
import java.awt.Color;
import java.awt.Graphics;

public class IstogrammaFrame extends JPanel{

	int array[] = new int[13];
	int h,w;
	int max;

	public IstogrammaFrame(String nome){
		prendiDatiFile(nome);
	}

	public void prendiDatiFile(String nome){

        String temp[] = new String [1];
        BufferedReader leggiriga = File.apriFileLettura(nome);
        String leggi="";
        int i = 0;

        try{
            leggi=leggiriga.readLine();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        try{
            while(leggi!=null){
                temp=leggi.split(",",2);
                array[i]=(Integer.parseInt(temp[1]));
                i++;
                leggi=leggiriga.readLine();
            }   
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }  
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		  w = getSize().width;
		  h = getSize().height;
		  disegnaIstogramma(g);
	}
	
	
	private void disegnaIstogramma(Graphics g)
	{
		int base;
		int altezza;
		int x=0;

		max=Integer.MIN_VALUE;

		for(int i=0;i<array.length;i++)
			if(array[i]>max)max=array[i];


			base=(int)Math.ceil((float)w/array.length);
			
			for(int i=0;i<array.length;i++){
				altezza=(int)Math.round((float)array[i]*h/max);
				g.setColor(new Color(160,160,160));
				g.fill3DRect(x, h-altezza, base, altezza, true);
				x+=base;
			 }	 	
		 }
     }
