package lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    static Map<String, Set<String>> phoneBook = new HashMap<>();
    static void add(String name, String phone) {
        if (!phoneBook.containsKey(name)) {
            Set<String> number = new HashSet<>();
            number.add(phone);
            phoneBook.put(name, number);
        } else {
            phoneBook.get(name).add(phone);
        }
    }
    static void get(String name) {
        System.out.println(name + phoneBook.get(name));
    }
}
