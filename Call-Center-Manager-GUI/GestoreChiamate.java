import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class GestoreChiamate extends JFrame implements ActionListener{
    //Istanze
    Rubrica rubrica;
    Chiamata chiamata;
    Amministratore amministratore;

    //Operatore
    JTextField textid = new JTextField();
    JCheckBox  esito = new JCheckBox();
    
    //Utente Chiamato
    JTextField textnumero = new JTextField();
    JTextField textdestinatario = new JTextField();
    
    //Orario
    JComboBox <Integer> comboore = new JComboBox<Integer>();
    JComboBox <Integer> combominuti = new JComboBox<Integer>();

    //Data
    JComboBox <Integer> combogiorni = new JComboBox<Integer>();
    JComboBox <Integer> combomesi = new JComboBox<Integer>();
    JComboBox <Integer> comboanni = new JComboBox<Integer>();

    //Pannello
    JPanel gestore = new JPanel();

    //TextArea
    JTextArea areadati = new JTextArea();

    //Bottoni
    JButton bottoneaddchiamata = new JButton("Aggiungi la chiamata");
    JButton bottoneAmministratore = new JButton("Amministratore MODE");
    JButton bottoneleggi = new JButton("Leggi Statistiche");

    //PW
    JTextField textpassword = new JTextField(20);
    private final String PW ="zenga1";

    public GestoreChiamate(){
        super("Call Center Alicino");
        rubrica = new Rubrica();

        setComponentiFinestra();
        setComponentiPannello();

        bottoneaddchiamata.addActionListener(this);
        bottoneAmministratore.addActionListener(this);
        bottoneleggi.addActionListener(this);
        
        setVisible(true);
        setSize(900,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void setComponentiFinestra(){
        setBordoArea("Visualizzatore");
        add(gestore,BorderLayout.WEST);
        add(new JScrollPane(areadati),BorderLayout.CENTER);
        areadati.setEditable(false);
    }

    private void setComponentiPannello(){
        inizializzaComponenti();
        gestore.setPreferredSize(new Dimension(200,700));
        gestore.setBackground(new Color(220,220,220));
        setBordoPannello("Informazioni della Chiamata");

        //Gestione Componenti
        gestore.setLayout(new GridLayout(21,2));
        gestore.add(new JLabel("Id Operatore"));
        gestore.add(textid);
        gestore.add(new JLabel("Nome Destinatario"));
        gestore.add(textdestinatario);
        gestore.add(new JLabel("Numero Destinatario"));
        gestore.add(textnumero);
        gestore.add(new JLabel("Orario (min/ore)"));
        gestore.add(combominuti);
        gestore.add(comboore);
        gestore.add(new JLabel("Data Attuale (gg/mm//aa)"));
        gestore.add(combogiorni);
        gestore.add(combomesi);
        gestore.add(comboanni);
        gestore.add(new JLabel("Esito Positivo?"));
        gestore.add(esito);
        gestore.add(new JLabel("Opzioni"));
        gestore.add(bottoneaddchiamata);
        gestore.add(bottoneleggi);
        gestore.add(new JLabel("Passa ad Amministratore"));
        gestore.add(bottoneAmministratore);
        gestore.add(textpassword);
    }

    private void setBordoPannello(String name){
        Border bordoInterno = BorderFactory.createTitledBorder(name);
        Border bordoEsterno = BorderFactory.createEmptyBorder(5,5,5,5);
        Border bordoFinale = BorderFactory.createCompoundBorder(bordoInterno,bordoEsterno);
        gestore.setBorder(bordoFinale);
    }

    private void setBordoArea(String name){
        Border bordoInterno = BorderFactory.createTitledBorder(name);
        Border bordoEsterno = BorderFactory.createEmptyBorder(5,5,5,5);
        Border bordoFinale = BorderFactory.createCompoundBorder(bordoInterno,bordoEsterno);
        areadati.setBorder(bordoFinale);
        areadati.setFont(new Font("Monospaced", Font.PLAIN, 15));
    } 

    private void inizializzaComponenti(){
        for (int index=1; index<32; index++) combogiorni.addItem(index);
        for (int index=1; index<13; index++) combomesi.addItem(index); 
        for (int index=2021; index<2023; index++) comboanni.addItem(index);
        for (int index=1; index<25; index++) comboore.addItem(index);
        for (int index=1; index<61; index++) combominuti.addItem(index);
    }

    private void resetComponenti(){
        textid.setText(null);
        esito.setSelected(false);      
        //Utente Chiamato
        textnumero.setText(null);
        textdestinatario.setText(null);
        //Orario
        comboore.setSelectedIndex(0);
        combominuti.setSelectedIndex(0); 
        //Data
        combogiorni.setSelectedIndex(0);
        combomesi.setSelectedIndex(0); 
        comboanni.setSelectedIndex(0);
    }

    private boolean controllaDati(){
        boolean verificato=true;
        if(Regex.controllo(textid.getText(),"[0-9]{10}")){  textid.setBackground(Color.red); verificato=false; }else{  textid.setBackground(null);}
        if(textnumero.getText().equals("")){  textnumero.setBackground(Color.red); verificato=false; }else{  textnumero.setBackground(null);}
        if(textdestinatario.getText().equals("")){  textdestinatario.setBackground(Color.red); verificato=false; }else{  textdestinatario.setBackground(null);}
        return verificato;
    }

    private boolean provaPassword(){
        boolean corretta=false;
        if(textpassword.getText().equals(PW)){
            corretta=true;
            textpassword.setBackground(null);
        }
        else{
            corretta=false;
            textpassword.setBackground(Color.RED);
            textpassword.setText(null);
        }
        return corretta;

    }

    public void actionPerformed(ActionEvent e){
        String temp = e.getActionCommand();
        if(temp.equals("Aggiungi la chiamata")){
            if(controllaDati()) {rubrica.addChiamata(new Chiamata(textid.getText(), esito.isSelected(), textnumero.getText(), textdestinatario.getText(), (int)comboore.getSelectedItem(), (int)combominuti.getSelectedItem(), (int)combogiorni.getSelectedItem(),(int) combomesi.getSelectedItem(), (int)comboanni.getSelectedItem())); resetComponenti(); areadati.setText("Chiamata aggiunta con Successo!");}
            else{areadati.setText("Mancano dei Dati!");}
        }
        else if(temp.equals("Leggi Statistiche")){
            if(rubrica.csvToString().equals(null)) {   areadati.setText("File Vuoto!");  }
            else {areadati.setText(rubrica.csvToString());}
        }
        else{
            if(provaPassword()){ setVisible(false);   amministratore = new Amministratore();}
            else{ return;}
        }
    }






    
}
