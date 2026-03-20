# 🏎️ Simulatore Gara Automobilistica (Gran Premio)

Un'applicazione Java interattiva che simula lo svolgimento di una gara di Formula 1. Il progetto gestisce la creazione di una griglia di partenza, la simulazione dei giri di pista con punteggi casuali e la generazione di una classifica finale.

## 📋 Funzionalità principali

- **Configurazione Dinamica**: Scelta del nome della pista, del numero di giri (max 70) e del numero di partecipanti (max 20).
- **Gestione Scuderie**: Selezione tra scuderie reali (Ferrari, Mercedes, RedBull, ecc.) o creazione di scuderie personalizzate.
- **Logica di Gara**: Simulazione di ogni singolo giro con accumulo di punteggi basati su algoritmi pseudocasuali.
- **Classifica Automatica**: Ordinamento dei piloti in tempo reale tramite algoritmo **Bubble Sort**.
- **Ricerca Pilota**: Funzione di ricerca specifica per visualizzare il piazzamento di un singolo pilota nel ranking finale.
- **Podio**: Visualizzazione rapida dei primi tre classificati.

## 🛠️ Architettura del Codice (OOP)

Il progetto è suddiviso in classi per garantire il massimo incapsulamento e pulizia:

* `Main.java`: Gestore del menu e del flusso principale (User Interface).
* `Gara.java`: La "Business Logic" che coordina piloti, griglia e turni.
* `Macchina.java`: Rappresenta l'oggetto veicolo con attributi come scuderia e numero di gara.
* `Pilota.java`: Gestisce l'anagrafica dei concorrenti.
* `Funzioni.java`: Libreria di utility per l'input da tastiera (gestione eccezioni) e pulizia console.

## 🚦 Come avviare il simulatore

1. Assicurati di avere il **JDK** (Java Development Kit) installato.
2. Scarica i file in una cartella dedicata.
3. Compila tutti i file dal terminale:
   ```bash
   javac *.java