# Aufgabe 3.3

In der Vorlesung wurde das Datenmodell für Prozesse besprochen.
Obwohl wir wissen, dass Betriebssysteme in C geschrieben sind,
werden wir jetzt mit JAVA arbeiten. Sie sollen mit Java ein Modell
für den Prozess-Kontroll-Block (PCB) erstellen. Dieses Modell soll in späteren Aufgaben erweitert werden und einfache Interaktionen simulieren. 

- Reflektieren Sie nochmals das vorgestellte Datenmodell. 
- Entwickeln Sie zuerst neben der Klasse ProcessControlBlock, die Klassen ProcessMetadata, ProcessThread, ProcessAddressSpace, ProcessFiles, die verschiedene Aspekte des PCB kapseln:
  - Achten Sie darauf, dass das Modell auch für mehrere Threads pro Prozess Gültigkeit haben kann. Entwickeln Sie im ersten Schritt aber ein Modell für 1 Thread pro Prozess.
  - Berücksichtigen Sie neben dem Datenmodell auch das Zustandsmodell von Prozessen.
  - Gehen Sie von einer 64-Bit CPU aus, die insgesamt 16 Register hat. Der Inhalt dieser Register ist zu verwalten.
  - Für die Klasse ProcessAddressSpace implementieren eine leere Klasse als Platzhalter.
  - In der Klassen Processfiles verwenden Sie Platzhalter für StdInput, StdOutput, StdError und die Executable Datei.
- Implementieren Sie ein einfaches Beispiel, dass ein PCB mit Beispieldaten erstellt.

# Aufgabe 3.5

Verwenden Sie nun das JAVA Modell aus Aufgabe 2.4. Erweitern Sie die Implementierung um Prozesse einfach verwalten zu können.

- Reflektieren Sie nochmals die Bedeutung von Systemaufrufen/Systemcalls.
- Definieren Sie eine Schnittstelle IBSProcess mit den Funktionen
  - createProcess()
  - forkProcess()
  - killProcess()
  - (denken Sie auch über Funktionen nach, die Ihnen den aktuellen Zustand eines Systems ausgeben)
- Implementieren Sie eine Klasse BS und verwenden dazu die definierte Schnittstelle.
- Erzeugen Sie ein Main Programm, dass
  - zuerst 5 Prozesse exemplarisch erzeugt (createProcess()),
  - dann von diesen Prozessen mit forkProcess() jeweils ein Kind „kopiert“
  - und entfernen sie anschließend mit killProcess() die Prozesse mit der ID 5 und 8.
