/*
 * Author: Anos Voldigoad
 * Last modified: April 8, 2021
 * Description: Analyze text file using ADT concept.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("ResultOfMethodCallIgnored")

public class Main {

    // Print out original file, return lower case content
    public static String readPrintFileNoPunc(String fileName) throws FileNotFoundException {
        String content = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
        System.out.println(content);
        return content.toLowerCase().replaceAll("[\\p{P}&&[^\u0027]]", "");
    }

    // Sort array alphabetically
    public static String[] contentToSortedWordArray(String content) {
        String[] words = content.split("\\s");
        Arrays.sort(words);
//        System.out.println(Arrays.toString(words));
//        for(int i = 0; i < words.length; i++) {
//            System.out.println(words[i]);
//        }
        return words;
    }

    public static void main(String[] args) throws FileNotFoundException {

        // Application header
        System.out.println("========================");
        System.out.println("   File analyzer v1.0   ");
        System.out.println("========================");

        // Load file
        Scanner loadFile = new Scanner(System.in);
        System.out.println("Please input your file name with extension in:");
        String fileName;
        fileName = loadFile.nextLine();
        System.out.println();

        // Handle file
        String content = readPrintFileNoPunc(fileName);
        readPrintFileNoPunc(fileName);
        contentToSortedWordArray(content);
        String[] words = contentToSortedWordArray(content);
        System.out.println();

        // Menu handle

        while (true) {
            Scanner menuChoice = new Scanner(System.in);
            // Menu list
            System.out.println("Please input your choice:");
            System.out.println("1: Search for particular word");
            System.out.println("2: Print out alphabetical list of all words");
            System.out.println("3: Quit");

            // Menu cases
            int input = Integer.parseInt(menuChoice.nextLine());
            switch (input) {
                case 1:

                    break;
                case 2:
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    System.out.println("Program exit!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu item not exist.");
                    System.out.println();
                    break;
            }
        }
    }
}