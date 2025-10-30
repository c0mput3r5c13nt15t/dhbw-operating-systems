public class Race extends Thread {
    private final int valueJ;

    public Race(int valueJ) {
        this.valueJ = valueJ;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            Container.j = valueJ;
            // System.out.println("Iteration i=" + i + " set j to " + valueJ +", j=" + Container.j);
            // Thread.yield();
            Container.k += Container.j;
            // System.out.println("Iteration i=" + i + " j should be " + valueJ + ", j=" + Container.j + " and k= " + Container.k);
            // Thread.yield();
        }
    }
}
