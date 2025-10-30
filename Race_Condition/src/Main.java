//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Race a = new Race(-1);
        Race b = new Race(1);

        a.start();
        b.start();

        try {
            a.join();
            b.join();
            System.out.println("Finished with j=" + Container.j + " and k=" + Container.k);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
