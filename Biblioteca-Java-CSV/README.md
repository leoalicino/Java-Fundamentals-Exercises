# 📚 Gestione Biblioteca (CRUD con Persistenza CSV)

Questo progetto Java simula la gestione di una bacheca libri, permettendo l'archiviazione permanente dei dati su un file esterno in formato CSV.

## 🛠️ Tecnologie e Concetti Utilizzati
- **OOP (Object Oriented Programming)**: Incapsulamento dei dati tramite classi dedicate.
- **I/O Streams**: Utilizzo di `FileWriter`, `PrintWriter` e `BufferedReader` per la gestione dei file.
- **Strutture Dati Dinamiche**: Gestione della memoria tramite `Vector<Libro>`.
- **Parsing di dati**: Conversione di stringhe CSV in oggetti Java tramite il metodo `split()`.

## 📂 Struttura del Progetto
- **`Libro.java`**: Il modello (Entity) che contiene gli attributi (autore, titolo, pagine, stato prestito).
- **`Libreria.java`**: La logica di business per gestire la collezione e le funzioni di ricerca.
- **`File.java`**: Una classe di utility statica per semplificare la lettura e scrittura su disco.
- **`App.java`**: Punto di ingresso (Main) per testare le funzionalità.

## 🚀 Funzionalità
- Aggiunta di nuovi libri con salvataggio automatico su `bacheca.csv`.
- Ricerca avanzata per **Titolo** o per **Autore**.
- Conversione automatica dell'oggetto in formato CSV e viceversa.