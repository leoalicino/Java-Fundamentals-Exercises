public class App {
    public static void main(String[] args) throws Exception {
        Libro libro = new Libro ("Gino","Massari",4,true);
        Libreria libreria = new Libreria();
        libreria.aggiungiLibro(libro);
        System.out.println(libreria.cercaDaAutore("Gino"));
    }
}
