# Java Threads / Race Conditions

- Erstellen Sie eine Klasse, die als Container für zwei globale Variablen j und k dient (static). Initialisieren Sie die Werte j=0, k=5.
- Erstellen Sie eine Thread-Klasse Race, die in der run()-Methode 10-mal eine Schleife durchläuft, in der zuerst den Wert j gesetzt wird und anschließend die Operation k=k+j durchführt wird.
- Erzeugen Sie in der Main-Methode zwei Threads, die den Wert j auf 1 bzw. auf -1 setzen.
- Lassen Sie das Programm mehrmals laufen. Beschreiben Sie das Ergebnis!
- Erleichtern Sie nach jeder Operation innerhalb der Schleife einen Thread-Wechsel durch Verwendung von Thread.yield(). Wie ändert sich das Ergebnis?
