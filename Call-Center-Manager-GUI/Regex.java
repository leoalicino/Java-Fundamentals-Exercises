import java.util.regex.*;

public class Regex {
    
    public static boolean controllo(String controllo,String contenuto){
        Pattern pattern = Pattern.compile(contenuto);
        Matcher matcher = pattern.matcher(controllo);
        boolean matchFound = matcher.find();

        return matchFound;
    }
    
}
