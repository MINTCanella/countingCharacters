import java.io.*;
import java.util.Objects;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        File inputFile;
        File outputFile;
        TreeMap<Character, Integer> counter;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Введите имя файла для чтения: ");
            inputFile = new File(reader.readLine());

            while (true) {
                if (!inputFile.exists()) {
                    System.out.print("Такого файла не существует." +
                            "\nВведите корректное имя файла для чтения: ");
                    inputFile = new File(reader.readLine());
                } else {
                    break;
                }
            }

            System.out.print("Введите имя файла для записи: ");
            outputFile = new File(reader.readLine());

            while (true) {
                if (Objects.equals(outputFile, inputFile)) {
                    System.out.print("Файл для чтения не должен совпадать с файлом для записи." +
                            "\nВведите другое имя файла: ");
                    outputFile = new File(reader.readLine());
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при вводе файлов: " + e.getMessage());
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            counter = Files.counting(reader);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("Подсчет символов в файле " + inputFile + ":\n");
            Files.writing(writer, counter);
            writer.write("Символов, не включенных в подсчет, нет в файле.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            return;
        }

        System.out.println("Успешно подсчитано.");
    }
}
