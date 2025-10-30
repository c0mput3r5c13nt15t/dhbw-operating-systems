import java.util.Stack;

public class ProcessThread {
    private int threadID;
    public enum ThreadStatus {
        READY,
        RUNNING,
        BLOCKED,
    }
    private ThreadStatus status;
    private int programCounter;
    private Stack<Integer> stack;

    private long[] registers;

    public ProcessThread(int threadID) {
        this.threadID = threadID;
        this.status = ThreadStatus.READY;
        this.programCounter = 0;
        this.stack = new Stack<>();
        this.registers = new long[16];
    }

    public void ready() {
        // Load registers into CPU
        this.status = ThreadStatus.READY;
    }
}
