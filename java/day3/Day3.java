import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.TreeMap;

public class Day3 {
    public static void main(String[] args) {
        partOne(parse("input.txt"));
    }

    public static void partOne(ArrayList<String> input) {
        TreeMap<Integer, ArrayList<Integer>> mapOfSymbolValues = new TreeMap<Integer, ArrayList<Integer>>();
        TreeMap<Integer, ArrayList<Integer>> mapOfNumberValues = new TreeMap<Integer, ArrayList<Integer>>();
        for (String line : input) {
            ArrayList<Integer> listOfSymbolIndexes = new ArrayList<>();
            ArrayList<Integer> listOfNumberIndexes = new ArrayList<>();
            
            int lineNumber = input.indexOf(line);

            char[] broken = line.replaceAll("[a-z0-9\\.]", "").toCharArray();
            int indexer = 0;
            for (Character eachChar : broken) {
                listOfSymbolIndexes.add(line.indexOf(eachChar, indexer));
                indexer++;
            }
            mapOfSymbolValues.put(Integer.valueOf(lineNumber), listOfSymbolIndexes);
            
            char[] brokenNum = line.replaceAll("[^0-9]", "").toCharArray();
            indexer = 0;
            for (Character eachChar : brokenNum) {
                listOfNumberIndexes.add(line.indexOf(eachChar, indexer));
                indexer = line.indexOf(eachChar, indexer) + 1;
            }
            mapOfNumberValues.put(Integer.valueOf(lineNumber), listOfNumberIndexes);


        }
        System.out.println("SYM: " + mapOfSymbolValues);
        System.out.println("NUM: " + mapOfNumberValues);

        for (Integer key : mapOfNumberValues.keySet()) {
            key = (int)key;
            for (int i = key - 1; i <= key + 1; i++) {
                if ((int)mapOfSymbolValues.get(i).get(i) - 1 == key) {

                }
            }
        }
    }

    public static ArrayList<String> parse(String path) {
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner cursor = new Scanner(new File(path))) {
            while (cursor.hasNextLine()) {
                lines.add(cursor.nextLine().trim());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return lines;
    }
}
