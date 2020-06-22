package lesson3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Задание 1
        String[] words = {"способ", "давление", "последствие", "способ", "грудь", "мысль", "грудь", "грудь",
                "мысль", "год", "очки", "мысль", "мысль", "борода"};
        Map<String, Integer> wordsMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            Integer value = wordsMap.getOrDefault(words[i], 0);
            wordsMap.put(words[i], value + 1);
        }
        System.out.println("Список уникальных слов:");
        wordsMap.forEach((k, v) -> {
            if (v == 1) {
                System.out.printf("%s\n", k);
            }
        });
        System.out.println("Число повторений каждого слова: " + wordsMap);

//        Задание 2
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+79136589622");
        phoneBook.add("Сидоров", "+79882567922");
        phoneBook.add("Иванов", "103");
        System.out.println(PhoneBook.phoneBook);
        phoneBook.get("Сидоров");


    }


}
