# 📞 Call Center Manager 2.0 (GUI & Data Analysis)

Un'applicazione gestionale avanzata per Call Center, dotata di interfaccia grafica (Java Swing) e sistema di persistenza dati. Il software permette agli operatori di registrare chiamate e agli amministratori di analizzare le performance.

## 🌟 Key Features
- **Interfaccia Grafica Avanzata**: Utilizzo di `JFrame`, `JPanel`, `LayoutManagers` e componenti interattive come `JComboBox` e `JCheckBox`.
- **Accesso Multi-Livello**: Interfaccia differenziata tra **Operatore** (inserimento dati) e **Amministratore** (statistiche e gestione file), protetta da password.
- **Validazione Dati con Regex**: Controllo degli input tramite espressioni regolari per garantire che numeri di telefono e ID siano nel formato corretto.
- **Data Persistence**: Salvataggio e lettura dei log delle chiamate su file `Registro.csv`.
- **Analisi Statistica**: Calcolo automatico del "Miglior Operatore" basato sul numero di esiti positivi.

## 📂 Struttura Tecnica
- **`GestoreChiamate.java`**: Il cuore della GUI dell'operatore e gestore degli eventi (`ActionListener`).
- **`Amministratore.java`**: Pannello di controllo per le funzioni di analisi e pulizia dati.
- **`Rubrica.java`**: Gestisce la logica di calcolo degli operatori e il parsing del file CSV.
- **`Chiamata.java` & `Operatore.java`**: Classi modello che definiscono la struttura dei dati.
- **`Regex.java`**: Utility class per la validazione formale degli input.

## 🚀 Istruzioni per l'uso
1. Compila il progetto: `javac *.java`
2. Avvia l'applicazione: `java Main`
3. Per accedere alla modalità amministratore, clicca su "Amministratore MODE" e usa la password predefinita.