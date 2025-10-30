//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(BS.BStoString());

        int gnomeProcessID = BS.createProcess(0, "/usr/bin/gnome-shell");
        BS.createProcess(gnomeProcessID, "/usr/bin/NetworkManager");
        BS.createProcess(gnomeProcessID, "/usr/bin/firefox");
        int terminalProcessID = BS.createProcess(gnomeProcessID, "/bin/bash");
        BS.createProcess(terminalProcessID, "ls");

        int forkedTerminalProcessID = BS.forkProcess(terminalProcessID);

        BS.killProcess(5);
        BS.killProcess(8);

        System.out.println(BS.BStoString());
    }
}