public interface IBSProcess {
    static int createProcess(int parentProcessID, String Executable) {
        return 0;
    }

    static int forkProcess(int processID) {
        return 0;
    }

    static void killProcess(int processID) {
        return;
    }
}
