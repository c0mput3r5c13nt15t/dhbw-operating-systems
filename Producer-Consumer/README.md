# Erzeuger-Verbraucher Problem

In den folgenden beiden Aufgaben soll das Erzeuger-Verbraucher Problem näher betrachtet werden. Der beschränkte Puffer soll als Ringpuffer (Array) realisiert werden. Der Erzeuger soll 100-mal in den Ringpuffer schreiben und der Verbraucher soll 100-mal aus dem Ringpuffer lesen. Die Kapazität des Ringpuffers soll auf 5 beschränkt bleiben. Machen Sie sich nochmals klar, was diese Anforderungen bzw. Randbedingungen bedeuten!

## Erzeuger-Verbraucher mit Java-Threads

Realisieren Sie eine Lösung für das Erzeuger-Verbraucher Problem mithilfe von Java Threads, indem Sie jeweils eine Klasse für den Erzeuger und für den Verbraucher erstellen. In einer weiteren Klasse soll dann jeweils ein Erzeuger und ein Verbraucher gestartet werden. Schauen Sie sich dazu nochmals die JavaDoc von Threads an!
- Laden Sie zuerst den Code mit dem Ringpuffer von der Webseite herunter.
- Erstellen Sie die benötigten Klassen unter Verwendung von JAVA Threads
- Ist diese Lösung frei von Deadlock? Begründen Sie ihre Antwort!
- Erzeugen Sie jeweils zwei Erzeuger bzw. Verbraucher Instanzen und führen Sie das Programm nochmals aus! Was beobachten Sie? Ist die Lösung frei von Verklemmungen?

## Erzeuger-Verbraucher mit Semaphoren

Realisieren Sie eine Lösung für das Erzeuger-Verbraucher Problem mithilfe von Semaphoren unter JAVA. Eine einfache Implementierung von Semaphoren steht mit dem BSync Paket auf der Downloadseite zur Verfügung. Erstellen Sie jeweils eine Klasse für den Erzeuger und den Verbraucher. Für die Synchronisation wird eine weitere Klasse erstellt.

- Laden Sie zuerst den Code mit dem Ringpuffer von der Webseite herunter.
- Erstellen Sie die benötigten Klassen unter Verwendung von JAVA Threads
- Ist diese Lösung frei von Deadlock? Begründen Sie ihre Antwort!
- Erzeugen Sie jeweils zwei Erzeuger bzw. Verbraucher Instanzen und führen Sie das Programm nochmals aus! Was beobachten Sie? Ist die Lösung frei von Verklemmungen?