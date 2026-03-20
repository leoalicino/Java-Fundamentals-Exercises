import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;


public class GestorePallinometro extends JFrame implements ActionListener{

    Pallinometro galton;
    IstogrammaFrame istogramma;
    InputFrame frame;
   
    //**JFrame*/
    private JFrame f;
    private JFrame f1;

    /**JPanel */
    private JPanel panelmenu;

    /**JButton */
    private JButton bottonecaselle;
    private JButton bottonedirezioni;
    private JButton bottoneleggifile;
    private JButton bottoneistogramma;
    private JButton bottoneconfronto;
    private JButton bottonerilancia;

    /**JtextArea */
    private JTextArea areadati;

    /**JComboBox */
    private JComboBox<Integer> combopalline; 

    /**Stringa nome del File */
    private String nomeFile="";


    /**Costruttore */
    /**
     * 
     * @param x  Intero --> Numero Palline da Lanciare
     */

    public GestorePallinometro(int x){
        super("Pannello di Controllo");

        lanciaPalline(x);

        /**Inizializzazione*/
        panelmenu = new JPanel();
        
        /**Inizializzaziope Bottoni */
        bottonecaselle = new JButton("Visualizza le Caselle");
        bottonedirezioni = new JButton("Visualizza le direzioni");
        bottoneleggifile = new JButton("Leggi il File");
        bottoneistogramma = new JButton("Osserva il grafico del lancio");
        bottoneconfronto = new JButton("Osserva quattro tipi di grafici");
        bottonerilancia = new JButton("Esegui un nuovo lancio");

        /**Inizializzazione ComboBox */
        combopalline= new JComboBox<Integer>();

        /**Inizializzazione JTextArea */
        areadati = new JTextArea();

        //**Metodi per il settaggio grafico della Finestra */
        customArea();
        setCustomComponenti();
        setComponentiFinestra();
        setComponentiPannello();
        inizializzaCombo();

        /**Component Listener */
        bottonecaselle.addActionListener(this);
        bottonedirezioni.addActionListener(this);
        bottoneleggifile.addActionListener(this);
        bottoneistogramma.addActionListener(this);
        bottoneconfronto.addActionListener(this);
        bottonerilancia.addActionListener(this);

        /**Attributi Finestra*/
        setSize(900,700);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    } 

    /**Metodo che lancia le palline, sovrascrivendo il FILE*/
    /**
     * 
     * @param x Intero --> Numero palline da lanciare
     */

    private void lanciaPalline(int x){   
        galton = new Pallinometro(x);
        galton.lancioPalline();
        File.scriviFile(galton,"Tiro da "+x+" palline.csv",false);
        nomeFile="Tiro da "+x+" palline.csv";
        JOptionPane.showMessageDialog(this,"File   'Tiro da "+x+" palline.csv'  aggiunto con successo!","Nuovo File",JOptionPane.INFORMATION_MESSAGE);
    }

   
    /**Metodo che effettua 4 Lanci per i Confronti*/
    /**
     * 
     * @param x Intero --> Numero palline da lanciare per Lancio
     */

    private void lanciaPallineConfronto(int x){
        int npalline = x;
        nomeFile="[Confronto] Istrogramma "+x+" Palline.csv";
        galton = new Pallinometro(npalline);
        galton.lancioPalline();
        File.scriviFile(galton,"[Confronto] Istrogramma "+x+" Palline.csv",false);
        JOptionPane.showMessageDialog(this,"File   '[Confronto] Istrogramma "+x+" Palline.csv'  aggiunto con successo!","Nuovo File",JOptionPane.INFORMATION_MESSAGE);
    }

    //**Metodo con la funzione di Inizializzare le ComboBox*/

    private void inizializzaCombo(){
     combopalline.addItem(10);
     combopalline.addItem(50);
     combopalline.addItem(100);
     combopalline.addItem(500);
     combopalline.addItem(1000);
     combopalline.addItem(5000);
     combopalline.addItem(10000);
     combopalline.addItem(50000);
     combopalline.addItem(100000);
    }

    //**Setta i componenti della finestra */

    private void setComponentiFinestra(){
        setBordoPannello("Menù del Pallinometro");
        add(panelmenu,BorderLayout.WEST);
        add(new JScrollPane(areadati),BorderLayout.CENTER);
    }

    /**Setta i componenti del pannelo */

    private void setComponentiPannello(){
        panelmenu.setLayout(new GridLayout(14,1,0,7));
        panelmenu.add(new JLabel(""));
        panelmenu.add(new JLabel(""));
        panelmenu.add(new JLabel(""));
        panelmenu.add(new JLabel(""));
        panelmenu.add(new JLabel(""));
        panelmenu.add(new JLabel(""));
        panelmenu.add(new JLabel(""));
        panelmenu.add(new JLabel(""));
        panelmenu.add(bottonecaselle);
        panelmenu.add(bottonedirezioni);
        panelmenu.add(bottoneleggifile);
        panelmenu.add(bottoneistogramma);
        panelmenu.add(bottoneconfronto);
        panelmenu.add(bottonerilancia);      
    }

    /**Setta il bordo del Pannello */
    private void setBordoPannello(String titolo){
        Border bordoInterno = BorderFactory.createTitledBorder(titolo);
        Border bordoEsterno = BorderFactory.createEmptyBorder(5,5,5,5);
        Border bordoFinale = BorderFactory.createCompoundBorder(bordoInterno,bordoEsterno);
        panelmenu.setBorder(bordoFinale);
        panelmenu.setFont(new Font("Monospaced", Font.PLAIN, 15));
    } 

    /**Setta il bordo dell'area */
    private void setBordoArea(String titolo){
        Border bordoInterno = BorderFactory.createTitledBorder(titolo);
        Border bordoEsterno = BorderFactory.createEmptyBorder(5,5,5,5);
        Border bordoFinale = BorderFactory.createCompoundBorder(bordoInterno,bordoEsterno);
        areadati.setBorder(bordoFinale);
        areadati.setFont(new Font("Monospaced", Font.PLAIN, 15));
    } 
    
    /**Modifica l'Estetica dei componenti */
    private void setCustomComponenti(){
        bottonecaselle.setFont(new Font("Avenir Next LT Pro", Font.PLAIN, 14));
        bottonecaselle.setBackground(new Color(160,160,160));
        bottonecaselle.setForeground(Color.white);

        bottonedirezioni.setFont(new Font("Avenir Next LT Pro", Font.PLAIN, 14));
        bottonedirezioni.setBackground(new Color(160,160,160));
        bottonedirezioni.setForeground(Color.white);

        bottoneleggifile.setFont(new Font("Avenir Next LT Pro", Font.PLAIN, 14));
        bottoneleggifile.setBackground(new Color(160,160,160));
        bottoneleggifile.setForeground(Color.white);

        bottoneistogramma.setFont(new Font("Avenir Next LT Pro", Font.PLAIN, 14));
        bottoneistogramma.setBackground(new Color(160,160,160));
        bottoneistogramma.setForeground(Color.white);

        bottoneconfronto.setFont(new Font("Avenir Next LT Pro", Font.PLAIN, 14));
        bottoneconfronto.setBackground(new Color(160,160,160));
        bottoneconfronto.setForeground(Color.white);

        bottonerilancia.setFont(new Font("Avenir Next LT Pro", Font.PLAIN, 14));
        bottonerilancia.setBackground(new Color(160,160,160));
        bottonerilancia.setForeground(Color.white);
    }    

    /**Attributi della JTextArea */

    private void customArea(){
        areadati.setEditable(false);
        areadati.setFont(new Font("Monospaced", Font.PLAIN, 15));
        setBordoArea("Area Dati");
    }

    /**Metodo che crea L'istogramma */
    /**
     * 
     * @param nomeFile Stringa --> Prende il nome del file da cui prelevare i dati
     */

    private void creaIstogramma(String nomeFile){
        /**Attributi Finestra Istogramma */
        f = new JFrame(); 
        f.setTitle("Istogramma '"+nomeFile+"'");
        f.setVisible(true); 
        f.setSize(600,600);
        f.setLocationRelativeTo(null);

        /**Metto il pannello all'interno della Finestra */
        istogramma = new IstogrammaFrame(nomeFile);
        f.add(istogramma);
    }


    private void confrontoGrafici(){
        int azione = JOptionPane.showConfirmDialog(this,"Sei sicuro di voler fare un Confronto? \nPerderai i dati del lancio attuale","Allerta Confronto!", JOptionPane.YES_OPTION,JOptionPane.WARNING_MESSAGE);
        if(azione!=JOptionPane.OK_OPTION) return; 
        int []p = new int [4];

        JOptionPane.showMessageDialog(this, combopalline, "Palline Grafico 1",JOptionPane.QUESTION_MESSAGE);
        int index = (int)combopalline.getSelectedItem();
        int point = combopalline.getSelectedIndex();
        combopalline.removeItemAt(point);
        lanciaPallineConfronto(index);
        p[0]=index;
        String n1="[Confronto] Istrogramma "+index+" Palline.csv";



        JOptionPane.showMessageDialog(this, combopalline, "Palline Grafico 2",JOptionPane.QUESTION_MESSAGE);
        index = (int)combopalline.getSelectedItem();
        point = combopalline.getSelectedIndex();
        combopalline.removeItemAt(point);
        lanciaPallineConfronto(index);
        p[1]=index;
        String n2="[Confronto] Istrogramma "+index+" Palline.csv";

        JOptionPane.showMessageDialog(this, combopalline, "Palline Grafico 3",JOptionPane.QUESTION_MESSAGE);
        index = (int)combopalline.getSelectedItem();
        point = combopalline.getSelectedIndex();
        combopalline.removeItemAt(point);
        lanciaPallineConfronto(index);
        p[2]=index;
        String n3="[Confronto] Istrogramma "+index+" Palline.csv";


        JOptionPane.showMessageDialog(this, combopalline, "Palline Grafico 4",JOptionPane.QUESTION_MESSAGE);
        index = (int)combopalline.getSelectedItem();
        point = combopalline.getSelectedIndex();
        combopalline.removeItemAt(point);
        lanciaPallineConfronto(index);
        p[3]=index;
        String n4="[Confronto] Istrogramma "+index+" Palline.csv";
        
        setVisible(false);  
        frame = new InputFrame(); 
        creaGraficiConfronto(n1,n2,n3,n4,p);
    }

    private void creaGraficiConfronto(String n1,String n2,String n3,String n4, int[]p){
        f1=new JFrame(); 
        f1.setTitle("Confronto 4 Istogrammi: ("+p[0]+"-"+p[1]+"-"+p[2]+"-"+p[3]+") ");
        f1.setSize(600,600);
        f1.setVisible(true); 

        f1.setLayout(new GridLayout(2,2));
        f1.add(new IstogrammaFrame(n1)); /**Aggiungo l'Istogramma 1 */
        f1.add(new IstogrammaFrame(n2)); /**Aggiungo l'Istogramma 2 */
        f1.add(new IstogrammaFrame(n3)); /**Aggiungo l'Istogramma 3 */
        f1.add(new IstogrammaFrame(n4)); /**Aggiungo l'Istogramma 4 */
    }

    
    /**Action Performed */
    public void actionPerformed(ActionEvent e){
        String aux = e.getActionCommand();
        if(aux.equals("Visualizza le Caselle")) areadati.setText(galton.stampaStatistiche());
        else if (aux.equals("Visualizza le direzioni")) areadati.setText(galton.stampaSequenza());
        else if (aux.equals("Leggi il File")) areadati.setText(File.csvToString(nomeFile));
        else if (aux.equals("Osserva il grafico del lancio"))  creaIstogramma(nomeFile);
        else if (aux.equals("Osserva quattro tipi di grafici")) confrontoGrafici();
        else {
            int azione = JOptionPane.showConfirmDialog(this,"Sei sicuro di voler fare un nuovo lancio?","Nuovo lancio", JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(azione==JOptionPane.YES_OPTION){
                setVisible(false);  
                frame = new InputFrame(); 
            }
            else; 
        }


    }

}
