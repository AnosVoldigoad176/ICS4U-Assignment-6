import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    // Reading in / printing out file
    public static String readAndPrintFile(String fileName) throws FileNotFoundException {
        String content = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
        return content.toLowerCase();
    }

    // Read the text file into array and split by word
    public static String[] readTxtToArrayByWord(String content) {
        String[] words = content.split("\\s");
        return words;
    }

    public static void main(String[] args) throws FileNotFoundException {

        // Application here
        System.out.println("========================");
        System.out.println("   File analyzer v1.0   ");
        System.out.println("========================");

        // Menu handle
        while (true) {

            // Menu list
            System.out.println("Please input your choice:");
            System.out.println("1: Read in text file");
            System.out.println("2: Print out the text file");
            System.out.println("3: Ordered binary tree with frequency");
            System.out.println("4: Search for an occurence of word");
            System.out.println("5: Print out an alphabetical list of all words and their frequency neatly\n" +
                    "in a table format.");
            System.out.println("6: Print out the total of all words contained within the document.");
            System.out.println("7: Quit");

            // Scanner

            Scanner s = new Scanner (System.in);
            String fileName;
            int input = Integer.parseInt(s.nextLine());
            switch (input) {
                case 1:
                    System.out.println("Please enter a file name");
                    fileName = s.nextLine();
                    String content = readAndPrintFile(fileName);
                    System.out.println(content);
                    readTxtToArrayByWord(content);
                    System.out.println();
                    System.out.println("File has been read in array by word!");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Test");
                    System.out.println("Please enter a word to be insterted ");
                    String item;
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    System.out.println("Program exit!");
                    System.exit(0);
                    break;
            }

        }

    }

}