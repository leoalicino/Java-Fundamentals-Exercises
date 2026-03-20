# 🚗 Gestione Garage con Pila (Stack) LIFO

Esercitazione in **Java** che simula la gestione di un garage utilizzando la struttura dati **Pila (Stack)**. Il progetto dimostra la comprensione della logica **LIFO** (Last-In, First-Out), dove l'ultima auto entrata è la prima a dover uscire.

## 🛠️ Architettura del Progetto

Il codice è strutturato seguendo i principi della programmazione a oggetti (OOP):

- **`Pila.java`**: Implementazione della struttura dati Stack utilizzando la classe `Vector` di Java. Include i metodi fondamentali: `push`, `pop`, `size` e `vuota`.
- **`Garage.java`**: Contiene la logica di business per gestire le operazioni di entrata e uscita dei veicoli.
- **`Main.java`**: Punto di ingresso dell'applicazione con un menu interattivo per l'utente.
- **`Funzioni.java`**: Classe di utility per la gestione sicura dell'input da tastiera e la pulizia della console.

## ✨ Funzionalità

- **Ingresso veicolo**: Aggiunge un'auto in cima alla pila.
- **Uscita singola**: Rimuove l'ultima auto parcheggiata.
- **Svuotamento totale**: Esegue il "pop" di tutti gli elementi fino a svuotare il garage.
- **Visualizzazione**: Stampa lo stato attuale della pila per monitorare i veicoli presenti.
- **Interfaccia CLI**: Menu testuale intuitivo con gestione della pulizia dello schermo.

## 🚀 Come eseguire l'applicazione

Assicurati di avere il **JDK** installato sul tuo PC.

1. Clona il repository o scarica i file.
2. Apri il terminale nella cartella del progetto.
3. Compila i file:
   ```bash
   javac *.java