import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) throws Exception {
    // Czy podano jeden argument (URL)
    if (args.length != 1) {
      System.out.println("Usage: java Main <URL>");
      return;
    }

    // Pobranie URL z argumentu
    URL url = new URL(args[0]);
    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
    StringBuilder input = new StringBuilder();
    String line;

    while ((line = reader.readLine()) != null) {
      input.append(line);
    }
    reader.close();

    Pattern pattern = Pattern.compile("href=\"(.*?\\.jpg)\"");
    Matcher matcher = pattern.matcher(input);

    while (matcher.find()) {
      System.out.println(matcher.group(1));
    }
  }
}
