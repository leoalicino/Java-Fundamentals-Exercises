import java.util.regex.*;

public class Regex{

    /**
     * 
     * @param contenuto Stringa da Verificare
     * @return Boolean del Risultato
     */
    
    public static boolean controlloStinga(String contenuto){
        String regex = "[0-9]+$";
        boolean result;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contenuto);

        result = matcher.matches();
        return result;
    }
}
