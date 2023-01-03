public class Derived extends Base {
    public Derived(String s) {
        System.out.print("D");
    }

    public static void main(String[] args) {
        new Derived("C");
    }
}
