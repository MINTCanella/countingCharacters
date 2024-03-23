import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Files {
    public static TreeMap<Character, Integer> counting(BufferedReader reader) throws IOException {
        TreeMap<Character, Integer> counter = new TreeMap<>();
        int c;
        while ((c = reader.read()) != -1) {
            char key = (char) c;
            if (counter.containsKey(key)) {
                counter.put(key, counter.get(key) + 1);
            } else {
                counter.put(key, 1);
            }
        }
        return counter;
    }

    public static void writing(FileWriter writer, TreeMap<Character, Integer> counter) throws IOException {
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
        }
    }
}
