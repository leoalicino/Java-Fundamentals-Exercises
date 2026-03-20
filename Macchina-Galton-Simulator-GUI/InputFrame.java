import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;


public class InputFrame extends JFrame implements ActionListener{

    GestorePallinometro frame;
    Pallinometro galton;

    //JPanel
    private JPanel pannello;
    //Jbutton
    private JButton bottoneinput;
    //JTextField
    private JTextField textfieldinput;
    //Jlabel
    private JLabel labelpalline;
    //Boolean 
    private boolean controllo;

    public InputFrame(){
        super("Macchina di Zenga");

        /*Inizializzazione*/
        pannello = new JPanel();
        bottoneinput = new JButton("Lancia");
        textfieldinput = new JTextField(5);
        labelpalline = new JLabel("     Numero palline");

        /*SetComponenti*/
        setComponentiFinestra();
        setComponentiPannello();
        setCustomComponenti();

        bottoneinput.addActionListener(this); //Ascoltatore

        /*Attributi Finestra*/
        setSize(300,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setComponentiFinestra(){
        setBordoPannello("Inserimento Dati");
        add(pannello);
    }

    public void setComponentiPannello(){
        pannello.setLayout(new GridLayout(6,2));
        pannello.add(new JLabel(""));
        pannello.add(new JLabel(""));
        pannello.add(labelpalline);
        pannello.add(new JLabel(""));
        pannello.add(textfieldinput);
        pannello.add(new JLabel(""));
        pannello.add(new JLabel(""));
        pannello.add(new JLabel(""));
        pannello.add(bottoneinput); 
    }

    private void setBordoPannello(String titolo){
        Border bordoInterno = BorderFactory.createTitledBorder(titolo);
        Border bordoEsterno = BorderFactory.createEmptyBorder(5,5,5,5);
        Border bordoFinale = BorderFactory.createCompoundBorder(bordoInterno,bordoEsterno);

        pannello.setBorder(bordoFinale);
        pannello.setFont(new Font("Monospaced", Font.PLAIN, 15));
    }     

    private void setCustomComponenti(){
        bottoneinput.setFont(new Font("Avenir Next LT Pro", Font.PLAIN, 14));
        bottoneinput.setBackground(new Color(160,160,160));
        bottoneinput.setForeground(Color.white);

        labelpalline.setFont(new Font("Avenir Next LT Pro", Font.PLAIN, 13));
    }

    private void controlloBottone(){
        controllo = false;
        if(Regex.controlloStinga(textfieldinput.getText())){
            controllo = true;
            if(Integer.parseInt(textfieldinput.getText())<10||Integer.parseInt(textfieldinput.getText())>100000){
                textfieldinput.setText("");
                JOptionPane.showMessageDialog(this,"Valore troppo piccolo o troppo grande! ","Errore",JOptionPane.ERROR_MESSAGE);
                controllo = false; 
            } 
        } 

        else if(textfieldinput.getText().equals("")) JOptionPane.showMessageDialog(this,"Non hai inserito nessun dato! ","Errore",JOptionPane.ERROR_MESSAGE);
        else{
            textfieldinput.setText("");
            JOptionPane.showMessageDialog(this,"Non hai inserito un dato numerico! ","Errore",JOptionPane.ERROR_MESSAGE);
            return;
        } 
    }

    private void eventoBottone(){
        controlloBottone();
        if(controllo){
            setVisible(false);
            frame = new GestorePallinometro(Integer.parseInt(textfieldinput.getText())); 
        }
    }

    public void actionPerformed(ActionEvent e){
        String aux=e.getActionCommand();
        if(aux.equals("Lancia")){
            eventoBottone();
        }
    }   
}
