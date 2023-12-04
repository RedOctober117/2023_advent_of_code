import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;

public class Day1 {
    public static void main(String[] args) {
        // partOne();
        // System.out.println("\n\n\n\n\n");
        partTwo();
    }

    public static void partOne() {
        try (Scanner cursor = new Scanner(new File("input.txt"))) {
            ArrayList<String> parsed = new ArrayList<>();
            while (cursor.hasNextLine()) {
                parsed.add(cursor.nextLine());
            }
            int sum = 0;    
            for (String s : parsed) {
                String trimmed = s.replaceAll("[a-zA-Z]", "");
                // System.out.println(trimmed);
                String add = String.format("%s%s", trimmed.substring(0, 1), trimmed.substring(trimmed.length() - 1, trimmed.length()));
                System.out.println(add);
                sum += (int)Integer.valueOf(add);
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    // https://ass.telemakos.io/Un82RPzuU5Ig
    public static void partTwo() {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        try (Scanner cursor = new Scanner(new File("input.txt"))) {
            ArrayList<String> parsed = new ArrayList<>();
            while (cursor.hasNextLine()) {
                parsed.add(cursor.nextLine());
            }

            int sum = 0;
            for (String s : parsed) {
                System.out.println(s);
                s = s.trim();
                String trimmedToWords = s.replaceAll("[^a-zA-Z]", "");
                String trimmedToNumbers = s.replaceAll("[^0-9]", "");
                System.out.println("TRIM NUM: " + trimmedToNumbers);
                System.out.println("TRIM WORD: " + trimmedToWords);

                TreeMap<Integer, Integer> mapOfValues = new TreeMap<>();
                for (int i = 0; i < trimmedToWords.length(); i++) {
                    for (int j = 0; j < numbers.length; j++) {
                        // System.out.println(numbers[j]);
                        if (trimmedToWords.contains(numbers[j])) {
                            if (s.indexOf(numbers[j], i) == -1) {
                                continue;
                            }
                            mapOfValues.put(s.indexOf(numbers[j], i), Integer.valueOf(j));
                        }
                    }
                }
                for (int i = 0; i < s.length(); i++) {
                    for (char c : trimmedToNumbers.toCharArray()) {
                        if (s.indexOf(c, i) == -1) {
                            continue;
                        }
                        mapOfValues.put(s.indexOf(c, i), Integer.parseInt(Character.toString(c)));
                    }
                }
                System.out.println(mapOfValues);
                System.out.println("CONCAT: " + Integer.valueOf(String.format("%s%s", mapOfValues.get(mapOfValues.firstKey()), mapOfValues.get(mapOfValues.lastKey()))));
                sum += Integer.valueOf(String.format("%s%s", mapOfValues.get(mapOfValues.firstKey()), mapOfValues.get(mapOfValues.lastKey())));
                System.out.println("CURRENT SUM: " + sum);
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }    
}
