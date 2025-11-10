# Dateien als Sperrmechanismus

Schreiben Sie ein C-Programm, das den Zugriff auf eine Ressource durchführen will. Die Ressource soll durch ein Lockfile (z.B. /tmp/.fileSema) geschützt werden. Die Erzeugung der Datei geschieht mit open() unter von write-only und exclusiv Optionen. Der Lock wird mit dem Befehl unlink() wieder freigegeben.

## Usage

```bash
gcc main.c
./a.out <file> "<string>"
```

Bei gleichzeitigem Zugriff:

```bash
./a.out resource.txt "A"
Lock gesetzt.
Lock wieder freigegeben.
```

aber

```bash
./a.out resource.txt "B"
Ressource ist bereits gesperrt!
```

Inhalt `resource.txt`:

```txt
Start write
A
End write

```
