import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Amministratore extends JFrame implements ActionListener{
    Rubrica rubrica;
    File file;
    GestoreChiamate operatore;

    //Text
    JTextArea areastatistiche = new JTextArea();
    JPanel pannello = new JPanel();

    //Jbutton
    JButton bottonestatistiche = new JButton("Statistiche");
    JButton bottonepulisci = new JButton("Svuota FILE");
    JButton bottoneoperatore = new JButton("Torna ad 'Operatore'");


    

    public Amministratore(){
        super("Finestra Amministratore");    
        file = new File();
        rubrica = new Rubrica();


        setComponentiFinestra();
        setComponentiPannello();
        bottonestatistiche.addActionListener(this);
        bottonepulisci.addActionListener(this);
        bottoneoperatore.addActionListener(this);
        
        bottonestatistiche.setEnabled(true);
        areastatistiche.setEditable(false);



        setVisible(true);
        setSize(900,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void setComponentiFinestra(){
        setBordoArea("Statistiche Amministratore");
        pannello.setBackground(new Color(220,220,220));        
        add(pannello,BorderLayout.WEST);
        add(areastatistiche,BorderLayout.CENTER);
    }

    private void setComponentiPannello(){
        pannello.setPreferredSize(new Dimension(200,400));
        setBordoPannello("Privilegi Amministratore");
        pannello.setLayout(new GridLayout(19,1));
        pannello.add(new JLabel("Gestione Pulsanti"));
        pannello.add(bottonestatistiche);
        pannello.add(bottonepulisci);
        pannello.add(bottoneoperatore);
    }

    private void setBordoArea(String name){
        Border bordoInterno = BorderFactory.createTitledBorder(name);
        Border bordoEsterno = BorderFactory.createEmptyBorder(5,5,5,5);
        Border bordoFinale = BorderFactory.createCompoundBorder(bordoInterno,bordoEsterno);
        areastatistiche.setBorder(bordoFinale);
        areastatistiche.setFont(new Font("Monospaced", Font.PLAIN, 15));
    }    

    private void setBordoPannello(String name){
        Border bordoInterno = BorderFactory.createTitledBorder(name);
        Border bordoEsterno = BorderFactory.createEmptyBorder(5,5,5,5);
        Border bordoFinale = BorderFactory.createCompoundBorder(bordoInterno,bordoEsterno);
        pannello.setBorder(bordoFinale);
        pannello.setFont(new Font("Monospaced", Font.PLAIN, 15));
    }      

    public void actionPerformed(ActionEvent e){
        String temp = e.getActionCommand();
        if(temp.equals("Statistiche")){
            bottonestatistiche.setEnabled(false);
            areastatistiche.setText("Ecco Chi è il miglior Operatore!\n"+rubrica.getBestOperatore());
        }
        else if(temp.equals("Svuota FILE")){
            file.clearFile("Registro.csv");
            areastatistiche.setText("File Svuotato con Successo!");
        }
        else{
            setVisible(false);
            operatore = new GestoreChiamate();
        }
        


        
    }
}