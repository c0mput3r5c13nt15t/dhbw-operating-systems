//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(BS.BStoString());

        int gnomeProcessID = BS.createProcess(0, "/usr/bin/gnome-shell");
        System.out.println(BS.BStoString());
        BS.createProcess(gnomeProcessID, "/usr/bin/NetworkManager");
        System.out.println(BS.BStoString());
        BS.createProcess(gnomeProcessID, "/usr/bin/firefox");
        System.out.println(BS.BStoString());
        int terminalProcessID = BS.createProcess(gnomeProcessID, "/bin/bash");
        System.out.println(BS.BStoString());
        BS.createProcess(terminalProcessID, "ls");
        System.out.println(BS.BStoString());

        BS.forkProcess(terminalProcessID);
        System.out.println(BS.BStoString());

        BS.killProcess(5);
        System.out.println(BS.BStoString());
        BS.killProcess(8);
        System.out.println(BS.BStoString());

        System.out.println(BS.BStoString());
    }
}