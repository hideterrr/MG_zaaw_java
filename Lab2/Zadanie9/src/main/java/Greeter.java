// 9. Zaimplementuj klas˛e Greeter, która implementuje interfejs Runnable i w której metoda run wy´swie-
// tla n kopii tekstu "Witaj, " + target, gdzie n i target s ˛a ustawiane w konstruktorze. Stwórz
// dwie instancje z ró˙znymi komunikatami i wykonaj je równolegle w dwóch w ˛atkach.

public class Greeter implements Runnable {
  private int n;
  private String target;

  public Greeter(int n, String target) {
    this.n = n;
    this.target = target;
  }

  @Override
  public void run() {
    for (int i = 0; i < n; i++) {
      System.out.println("Witaj!, " + target);
    }
  }
}