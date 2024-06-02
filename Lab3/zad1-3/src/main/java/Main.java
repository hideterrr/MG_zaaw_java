// Korzystaj ˛ac z metod listFiles(FileFilter) oraz isDirectory z klasy
// java.io.File, napisz metod˛e zwracaj ˛ac ˛a wszystkie podkatalogi wskazanego katalogu. Wykorzystaj wyrazenie lambda zamiast obiektu ˙ FileFilter. Wykonaj to samo za
// pomoc ˛a wyrazenia z metod ˛a i anonimowej klasy wewn˛etrznej.

import java.io.File;
import java.io.FileFilter;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File directory = new File("/.java");

        // Wykorzystanie wyrażenia lambda
        File[] subdirectoriesLambda = directory.listFiles(File::isDirectory);
        System.out.println("Podkatalogi (wyrażenie lambda):");
        for (File subdirectory : subdirectoriesLambda) {
            System.out.println(subdirectory.getName());
        }
    }
}

/////////////////////////////////////////////////////////////////////////
      
//         // Klasa wewnętrzna
//         File[] subdirectoriesAnonymous = directory.listFiles(new FileFilter() {
//             @Override
//             public boolean accept(File pathname) {
//                 return pathname.isDirectory();
//             }
//         });
//         System.out.println("\nPodkatalogi (klasa wewnętrzna):");
//         for (File subdirectory : subdirectoriesAnonymous) {
//             System.out.println(subdirectory.getName());
//         }
//     }
// }
