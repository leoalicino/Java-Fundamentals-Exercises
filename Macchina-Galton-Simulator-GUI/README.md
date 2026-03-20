# 📉 Galton Machine Simulator (Pallinometro)

Un simulatore statistico avanzato con interfaccia grafica che riproduce la "Macchina di Galton". Il programma simula la caduta di migliaia di palline attraverso una griglia di pioli, dimostrando visivamente la distribuzione binomiale (che approssima la curva normale).

## 🚀 Caratteristiche Principali
- **Motore di Simulazione**: Gestione di un numero elevato di lanci (fino a 100.000) con tracciamento dei percorsi casuali (Destra/Sinistra).
- **Visualizzazione Grafica**: Generazione di un istogramma in tempo reale utilizzando la libreria `java.awt.Graphics` per rappresentare la densità nelle caselle.
- **Confronto Multiplo**: Funzionalità unica per confrontare visivamente quattro diversi set di dati salvati.
- **Validazione Robust**: Controllo degli input tramite Regex per prevenire inserimenti errati o fuori scala.
- **Persistenza Dati**: Esportazione e importazione dei risultati in formato CSV per analisi storiche.

## 📂 Architettura Classi
- **`Pallinometro.java`**: Motore matematico della simulazione.
- **`IstogrammaFrame.java`**: Componente custom per il rendering grafico del diagramma a barre.
- **`GestorePallinometro.java`**: Pannello di controllo principale con gestione eventi.
- **`InputFrame.java`**: Finestra di configurazione iniziale con validazione.
- **`File.java`**: Gestore I/O per il salvataggio dei risultati dei lanci.
- **`Stringhe.java`**: Centralizzazione di tutti i testi e messaggi dell'interfaccia.

## 🛠️ Come eseguirlo
1. Compila tutto: `javac *.java`
2. Avvia il Main: `java Main`
3. Inserisci il numero di palline e osserva la magia della statistica!