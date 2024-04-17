package algorithms.itogJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
Входные данные:
Ваш файл `input.txt` содержит множество слов, разделенных
пробелами. Это слова-фрукты, овощи и другие продукты.
Представьте, что это ваш виртуальный пикник! 🍎🥕🥧
Задания:
1. Осуществить подсчет слов:
Напишите программу, которая подсчитывает количество слов в
файле `input.txt`.
2. Найти самое длинное слово:
Создайте программу, которая находит самое длинное слово в
файле.
3. Вычислить частоту слов:
Напишите программу, которая анализирует, сколько раз каждое
слово встречается в файле. Подумайте об этом как о подсчете того,
какие фрукты и овощи самые популярные на вашем пикнике!
 */
public class Picnic {
    public static void main(String[] args) {
        List<String> dataList = readFileToList("input.txt");

        System.out.println("Data from file:");
        for (String data : dataList) {
            System.out.println(data);
        }
        System.out.println("Количество слов: " + countStroki((ArrayList<String>) dataList));
        System.out.println("Самое длинное слово: " + longestWord((ArrayList<String>) dataList));
        wordFrequency((ArrayList<String>) dataList);

    }

    public static List<String> readFileToList(String fileName) {
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                list.addAll(Arrays.asList(words));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }


    public static int countStroki(ArrayList<String> lol) {
        return lol.size();
    }

    public static LinkedHashSet<String> longestWord(ArrayList<String> lol) {
        LinkedHashSet<String> arr = new LinkedHashSet<>();
        int longesLength = 0;

        for (String word : lol) {
            int wordLength = word.length();
            if (wordLength > longesLength) {
                arr.clear();
                arr.add(word);
                longesLength = wordLength;
            } else if (wordLength == longesLength) {
                arr.add(word);

            }
        }

        return arr;
    }

    public static void wordFrequency(ArrayList<String> lol) {
        Map<String, Integer> map = new HashMap<>();
        for (String item : lol) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }

        for (Map.Entry<String, Integer> item : map.entrySet()) {
            System.out.println("Продукт: " + item.getKey() + ", количество в списке: " + item.getValue());
        }

    }
}

