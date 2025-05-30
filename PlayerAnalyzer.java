/*
Dorian Carter Jr.

This Java application reads player names and their corresponding high scores from a file (playerData2.txt), sorts them in descending order based on scores, calculates the average score, and displays a formatted leaderboard. It also highlights the top X players with the highest scores. The project demonstrates file I/O operations, array manipulation, sorting algorithms, and formatted output in Java.

Key Features:

Reads up to 80 players and their scores from a text file

Sorts players by score using selection sort

Displays a leaderboard and calculates the average score

Highlights the top 10 players
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] names = new String[80];
        int[] scores = new int[80];
        
        readPlayerData(names, scores, "playerData2.txt");

        sortPlayersByScore(names, scores);

        int playerCount = 0;
        for (String name : names) {
            if (name == null) break;
            playerCount++;
        }

        double averageScore = calculateAverageScore(scores, playerCount);
        System.out.printf("\nAverage Score: %.2f\n", averageScore);
        displayPlayerData(names, scores);

        displayTopPlayers(names, scores, 10);
    }

    public static void readPlayerData(String[] names, int[] scores, String filename) throws IOException {
        File myFile = new File(filename);
        Scanner scanner = new Scanner(myFile);

        for (int i = 0; i < names.length && scanner.hasNext(); i++) {
            names[i] = scanner.next();
            scores[i] = scanner.nextInt();
            scanner.nextLine();
        }
    }

    public static void displayPlayerData(String[] names, int[] scores) {
        System.out.println("Player Name         High Score");
        System.out.println("------------------- ----------");
        for (int i = 0; i < names.length && names[i] != null; i++) {
            System.out.println(names[i] + " ".repeat(20 - names[i].length()) + scores[i]);
        }
    }
    public static double calculateAverageScore(int[] scores, int count) {
        if (count == 0) {
            return 0;
        }

        int total = 0;
        for (int i = 0; i < count; i++) {
            total += scores[i];
        }
        return (double) total / count;
    }
    public static void sortPlayersByScore(String[] names, int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIndex]) {
                    maxIndex = j;
            }

            int tempScore = scores[i];
            scores[i] = scores[maxIndex];
            scores[maxIndex] = tempScore;

            // Swap corresponding names
            String tempName = names[i];
            names[i] = names[maxIndex];
            names[maxIndex] = tempName;
        }
    }

    public static void displayTopPlayers(String[] names, int[] scores, int topX) {
        System.out.println("\nTop " + topX + " Players:");
        System.out.println("Player Name         High Score");
        System.out.println("------------------- ----------");

        for (int i = 0; i < topX && i < names.length && names[i] != null; i++) {
            System.out.println(names[i] + " ".repeat(20 - names[i].length()) + scores[i]);
        }
    }

}
