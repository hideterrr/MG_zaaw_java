// 5. Metoda codePoints ze slajdu 4, jest odrobin˛e niezgrabna, poniewa˙z wypełnia najpierw tablic˛e
// typu ArrayList, a nast˛epnie zamienia j ˛a na strumie´n. Napisz zamiast niej wyra˙zenie korzystaj ˛ace
// ze strumieni, u˙zywaj ˛ac metody IntStream.iterate do skonstruowania sko´nczonego strumienia
// offsetów, a nast˛epnie wyodr˛ebnij podła´ncuchy

import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    String str = "TekstJava"; // tekst do zastąpienia

    IntStream codePointStream = IntStream.iterate(0,
        offset -> offset < str.length(),
        offset -> offset + Character.charCount(str.codePointAt(offset)))
        .mapToObj(offset -> str.substring(offset,
            offset +
                Character.charCount(str.codePointAt(offset))))
        .flatMapToInt(String::codePoints);

    // wypisanie
    codePointStream.forEach(System.out::println);
  }
}
