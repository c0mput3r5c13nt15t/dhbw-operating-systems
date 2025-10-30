import java.util.HashMap;
import java.util.Map;

public class ProcessControlBlock {
    private final int processID;
    public enum ProcessStatus {
        READY,
        RUNNING,
        BLOCKED
    }
    private ProcessStatus status;

    private long[] heap;

    private ProcessMetadata metadata;
    private Map<Integer, ProcessThread> threads;
    private ProcessAddressSpace addressSpace;
    private ProcessFiles files;

    public ProcessControlBlock(int processID, ProcessControlBlock parent, User user, String executable) {
        this(processID, user, executable);
        this.metadata = new ProcessMetadata(parent.getProcessID(), user.getUserID(), user.getGroupID());
    }

    public ProcessControlBlock(int processID, User user, String executable) {
        this.processID = processID;
        this.status = ProcessStatus.READY;

        this.heap = new long[1];

        this.metadata = new ProcessMetadata(processID, user.getUserID(), user.getGroupID()); // The init process is its own parent

        ProcessThread mainThread = new ProcessThread(0);
        this.threads = new HashMap<>() {{
            put(0, mainThread);
        }};

        this.addressSpace = new ProcessAddressSpace();
        this.files = new ProcessFiles(executable);

        System.out.println("User=" + user.getName() + " created process for " + executable + " with PID=" + processID);
    }

    public ProcessControlBlock(int processID, ProcessControlBlock oldProcess) {
        this.processID = processID;
        this.status = ProcessStatus.READY;

        this.heap = oldProcess.heap.clone();

        this.metadata = new ProcessMetadata(oldProcess.metadata.getParentProcessID(), oldProcess.metadata.getUserID(), oldProcess.metadata.getGroupID());

        try {
            this.threads = new HashMap<>();
            for (Map.Entry<Integer, ProcessThread> e : oldProcess.threads.entrySet()) {
                ProcessThread original = e.getValue();
                ProcessThread cloned = (ProcessThread) original.clone();
                this.threads.put(e.getKey(), cloned);
            }
            this.addressSpace = (ProcessAddressSpace) oldProcess.addressSpace.clone();
            this.files = (ProcessFiles) oldProcess.files.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Duplicating process with PID=" + oldProcess.processID + " as PID=" + processID);
    }

    public int getProcessID() {
        return processID;
    }

    public void ready() {
        status = ProcessStatus.READY;
    }

    public void run() {
        status = ProcessStatus.RUNNING;
    }

    public void block() { status = ProcessStatus.BLOCKED; }

    public void stop() {
        // Do cleaning up
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProcessControlBlock {")
                .append("PID=").append(processID)
                .append(", exec=").append(files.getExecutable())
                .append(", Status=").append(status);

        if (metadata != null) {
            sb.append(", ParentPID=").append(metadata.getParentProcessID())
                    .append(", UserID=").append(metadata.getUserID())
                    .append(", GroupID=").append(metadata.getGroupID());
        }

        sb.append("}");

        return sb.toString();
    }
}
