import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Day2 {
    public static void main(String[] args) {
        partOne();
        System.out.println("\n\n\n\n");
        partTwo();
    }

    public static void partOne() {
        final int RED = 12;
        final int GREEN = 13;
        final int BLUE = 14;

        try (Scanner cursor = new Scanner(new File("input.txt"))) {
            ArrayList<String> lines = new ArrayList<>();
            while (cursor.hasNextLine()) {
                lines.add(cursor.nextLine().trim());
            }

            int gameNumSum = 0;
            for (String s : lines) {
                int gameNumber = Integer.valueOf(s.split(" ")[1].replaceAll("[^0-9]", ""));
                System.out.println(gameNumber);
                int successRate = 0;
                for (String game : s.split(";")) {
                    int red = 0;
                    int green = 0;
                    int blue = 0;
                    // System.out.println(game);
                    if (game.contains("red")) {
                        String[] y = game.substring(0, game.indexOf("red")).split(" ");
                        red += Integer.valueOf(y[y.length - 1]);
                    }
                    if (game.contains("green")) {
                        String[] y = game.substring(0, game.indexOf("green")).split(" ");
                        green += Integer.valueOf(y[y.length - 1]);
                    }
                    if (game.contains("blue")) {
                        String[] y = game.substring(0, game.indexOf("blue")).split(" ");
                        blue += Integer.valueOf(y[y.length - 1]);
                    }
                    System.out.printf("red %d green %d blue %d\n", red, green, blue);
                    if (red <= RED && green <= GREEN && blue <= BLUE) {
                        successRate++;
                    }
                }
                if (successRate == s.split(";").length) {
                    gameNumSum += gameNumber;
                }
            }
            System.out.println(gameNumSum);
        } catch (FileNotFoundException e) { 
            System.out.println(e);
        }
    }

    public static void partTwo() {
        try (Scanner cursor = new Scanner(new File("input.txt"))) {
            ArrayList<String> lines = new ArrayList<>();
            while (cursor.hasNextLine()) {
                lines.add(cursor.nextLine().trim());
            }
            
            int gameNumSum = 0;
            for (String s : lines) {
                int gameNumber = Integer.valueOf(s.split(" ")[1].replaceAll("[^0-9]", ""));
                System.out.println(gameNumber);
                int red = 0;
                int green = 0;
                int blue = 0;
                for (String game : s.split(";")) {
                    if (game.contains("red")) {
                        String[] y = game.substring(0, game.indexOf("red")).split(" ");
                        if (Integer.valueOf(y[y.length - 1]) > red) {
                            red = Integer.valueOf(y[y.length - 1]);
                        }
                    }
                    if (game.contains("green")) {
                        String[] y = game.substring(0, game.indexOf("green")).split(" ");
                        if (Integer.valueOf(y[y.length - 1]) > green) {
                            green = Integer.valueOf(y[y.length - 1]);
                        }
                    }
                    if (game.contains("blue")) {
                        String[] y = game.substring(0, game.indexOf("blue")).split(" ");
                        if (Integer.valueOf(y[y.length - 1]) > blue) {
                            blue = Integer.valueOf(y[y.length - 1]);
                        }
                    }
                    System.out.printf("red %d green %d blue %d\n", red, green, blue);
                    
                }
                gameNumSum += (red * green * blue);
            }
            System.out.println(gameNumSum);


        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
