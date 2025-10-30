import java.util.*;

public class BS implements IBSProcess {
    private static Map<Integer, User> users;
    private static int currentUserID;

    private static Map<Integer, ProcessControlBlock> processTable;

    private static Queue<Integer> readyQueue = new PriorityQueue<>();
    private static Queue<Integer> blockedQueue = new PriorityQueue<>();
    private static Optional<Integer> runningProcessID =  Optional.empty();

    static {
        System.out.println("Initializing BS...");
        User root = new User("root", 1000, 1000);
        users = new HashMap<>() {{
            put(root.getUserID(), root);
        }};
        currentUserID = root.getUserID();

        ProcessControlBlock init = new ProcessControlBlock(0, users.get(currentUserID), "init");

        processTable = new HashMap<>() {{
            put(init.getProcessID(), init);
        }};

        readyQueue.add(init.getProcessID());

        runNextProcess();
    }

    private static void takeControl() {
        // BS takes control of the CPU
        // BS sets the active process to ready (save registers, pointers, etc.)

        if (runningProcessID.isPresent()) {
            processTable.get(runningProcessID.get()).ready();
            readyQueue.add(runningProcessID.get());
            runningProcessID = Optional.empty();
        }
    }

    private static void releaseControl() {
        // BS releases CPU
        // BS calls scheduler -> set process from readyQueue to running

        runNextProcess();
    }

    private static void runNextProcess() {
        if (readyQueue.isEmpty()) { return; }

        int nextProcessID =  readyQueue.poll();
        runningProcessID = Optional.of(nextProcessID);
        processTable.get(nextProcessID).run();
    }

    public static int createProcess(int parentProcessID, String Executable) {
        takeControl();

        int newProcessID = getNewProcessID();

        ProcessControlBlock newProcess = new ProcessControlBlock(newProcessID, processTable.get(parentProcessID), users.get(currentUserID), Executable);

        processTable.put(newProcess.getProcessID(), newProcess);

        newProcess.ready();

        readyQueue.add(newProcess.getProcessID());

        releaseControl();

        return newProcess.getProcessID();
    }

    public static int forkProcess(int processID) {
        takeControl();

        int newProcessID = getNewProcessID();
        ProcessControlBlock oldProcess = processTable.get(processID);

        ProcessControlBlock newProcess = new ProcessControlBlock(newProcessID, oldProcess);

        processTable.put(newProcess.getProcessID(), newProcess);

        newProcess.ready();

        readyQueue.add(newProcess.getProcessID());

        System.out.println(newProcess);
        System.out.println(oldProcess);

        releaseControl();

        return newProcess.getProcessID();
    }

    public static void killProcess(int processID) {
        takeControl();

        if (processTable.containsKey(processID)) {
            processTable.get(processID).stop();

            processTable.remove(processID);
            readyQueue.remove(processID);
            blockedQueue.remove(processID);

            System.out.println("Killing process with PID=" + processID);
        } else {
            System.out.println("Killing process with PID=" + processID + " failed: no such process");
            releaseControl();
        }

        releaseControl();
    }

    private static int getNewProcessID() {
        int processID = 0;
        while (processTable.containsKey(processID)) {
            processID += 1;
        }
        return processID;
    }

    public static String BStoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== BS System State ===\n");

        sb.append("\nProcesses:\n");
        for (Map.Entry<Integer, ProcessControlBlock> entry : processTable.entrySet()) {
            sb.append("  PID: ").append(entry.getKey())
                    .append(" -> ").append(entry.getValue()).append("\n");
        }

        sb.append("\nReady Queue: ").append(readyQueue).append("\n");
        sb.append("Blocked Queue: ").append(blockedQueue).append("\n");

        sb.append("\nRunning process: ").append(runningProcessID.isPresent() ? runningProcessID.get() : "no process").append("\n");

        sb.append("========================");

        return sb.toString();
    }
}
