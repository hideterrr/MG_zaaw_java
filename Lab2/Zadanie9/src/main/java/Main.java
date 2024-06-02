public class Main {
  public static void main(String[] args) {
    Greeter greeter1 = new Greeter(5, "Alice");
    Greeter greeter2 = new Greeter(3, "Bob");

    Thread thread1 = new Thread(greeter1);
    Thread thread2 = new Thread(greeter2);

    thread1.start();
    thread2.start();
  }
}