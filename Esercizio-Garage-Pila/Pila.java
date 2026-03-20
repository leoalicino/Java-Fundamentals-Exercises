import java.util.*;

class Pila {
  // Creazione Array Dinamico
  private Vector elementi;

  // Costructor
  public Pila() {
    elementi = new Vector();
  }

  // Size Pila NON RESTITUISCE NULLA
  public int size() {
    return elementi.size();
  }

  // Push Pila
  public void push(Object obj) {
    elementi.addElement(obj);
  }

  // Pop Pila NON RESTITUISCE NULLA
  public Object pop() {
    Object obj = null;
    int size = elementi.size();

    if (size > 0) {
      obj = elementi.elementAt(size - 1);
      elementi.removeElementAt(size - 1);
    }
    return obj;
  }

  // Vuota Pila RESTITUISCE BOOLEAN
  public boolean vuota() {
    if (size() == 0)
      return true;
    else
      return false;
  }

  public void stampa() {
    System.out.println("" + elementi);
  }
}
