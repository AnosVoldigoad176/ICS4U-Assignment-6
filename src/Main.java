/*
 * Author: Anos Voldigoad
 * Last modified: April 9, 2021
 * Description: Analyze text file using BST.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SuppressWarnings({"SpellCheckingInspection"})

public class Main {

    private static int totalWordsCounter;
    private static WordNode root;

    /**
     * Method Name: contentToWordsBST
     *
     * @param content Content can be text paragraph or whatever to input into the tree
     *                Return: N/A
     *                Data Type: Void
     *                Dependencies: N/A
     *                Throws/Exception: N/A
     * @author Duc Anh Vu
     * Creation Date: April 9, 2021
     * Modified Date: April 9, 2021
     * Description: Input content of a text file into the tree, divided one word per node.
     */
    public static void contentToWordsBST(String content) {
        String word;
        while (true) {
            int divided = content.indexOf(' ') + 1;
            word = content.substring(0, divided).trim();
            content = content.substring(divided);
            if (word.length() == 0)
                break;
            if (treeContains(root, word, 0)) {
            } else {
                treeInsert(word);  // Add string to the tree.
            }
        }  // end while
    }

    /**
     * Method Name: plusCount
     *
     * @param node Node
     *             Return: N/A
     *             Data Type: Void
     *             Dependencies: N/A
     *             Throws/Exception: N/A
     * @author Duc Anh Vu
     * Creation Date: April 9, 2021
     * Modified Date: April 9, 2021
     * Description: Count in node plus by one everytime duplicate insert
     */
    private static void plusCount(WordNode node) {
        node.counter += 1;
    }

    /**
     * Method Name: treeInsert
     * @author Kyle Mckay
     * Creation Date:
     * Modified Date: April 9, 2021
     * Description: Insert all word into tree
     * @param word Word to insert to tree
     * Return: N/A
     * Data Type: Void
     * Dependencies: N/A
     * Throws/Exception: N/A
     */
    private static void treeInsert(String word) {
        if (root == null) {
            root = new WordNode(word);
            return;
        }
        WordNode runner;  // Runs down the tree to find a place for newItem.
        runner = root;   // Start at the root.
        while (true) {
            if (word.compareTo(runner.word) < 0) {
                if (runner.left == null) {
                    runner.left = new WordNode(word);
                    return;
                }
                else
                    runner = runner.left;
            } else {
                if (runner.right == null) {
                    runner.right = new WordNode(word);
                    return;
                } else {
                    runner = runner.right;
                }
            }
        } // End while
    }  // End treeInsert()

    /**
     * Method Name: treeContains
     * @author Kyle Mckay
     * Creation Date:
     * Modified Date: April 9, 2021
     * Description: Check if the tree contain something and show counter as well
     * @param root Root of the tree
     * @param word Word to search
     * @param Search Search = 1 mean found, = 0 mean not found
     * @return Total number occurence of the input word
     * Data Type: Boolean
     * Dependencies: N/A
     * Throws/Exception: N/A
     */
    public static boolean treeContains(WordNode root, String word, int Search) {
        if (root == null) {
            // Tree is empty, so it certainly doesn't contain item.
            return false;
        } else if (word.equals(root.word)) {
            // Yes, the item has been found in the root node.
            if (Search == 1) { // if it's a search for an item, want to print message
                System.out.println("\"" + word + "\"" + " appears " + "(" + root.counter + ")" + " time(s)"); // print the number of items
            } else { // if it's used to increase the value of counter
                plusCount(root); // call method, increase the value of counter
            }
            return true;
        } else if (word.compareTo(root.word) < 0) {
            // If the item occurs, it must be in the left subtree.
            return treeContains(root.left, word, Search);
        } else {
            // If the item occurs, it must be in the right subtree.
            return treeContains(root.right, word, Search);
        }
    }  // End treeContains()

    /**
     * Method Name: treeList
     * @author Kyle Mckay
     * Creation Date:
     * Modified Date: April 9, 2021
     * Description: Print the tree in order
     * @param node A node of the tree as start point
     * Return: N/A
     * Data Type: Void
     * Dependencies: N/A
     * Throws/Exception: N/A
     */
    public static void treeList(WordNode node) {
        if (node != null) {
            treeList(node.left);
            System.out.print("  " + node.word);
            if (node.word.length() > 15) {
                System.out.println("\t" + node.counter);
            } else if (node.word.length() < 5) {
                System.out.println("\t\t" + node.counter);
            } else {
                System.out.println("\t\t\t" + node.counter);
            }
            treeList(node.right);
        }
    } // End treeList()

    /**
     * Method Name: countTotalNodes
     * @author Duc Anh Vu
     * Creation Date: April 6, 2021
     * Modified Date: April 9, 2021
     * Description: Count total nodes inside a tree
     * @param node A node of the tree as start point
     * @return Total node
     * Data Type: Integer
     * Dependencies: N/A
     * Throws/Exception: N/A
     */
    public static int countTotalNodes(WordNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftCount = countTotalNodes(node.left);
            int rightCount = countTotalNodes(node.right);
            return  1 + leftCount + rightCount;
        }
    } // End countTotalNodes()

    /**
     * Method Name: countTotalWords
     * @author Duc Anh Vu
     * Creation Date: April 6, 2021
     * Modified Date: April 9, 2021
     * Description: Count total of words that got input in the tree
     * @param node A node of the tree as start point
     * @return Total of words in the tree
     * Data Type: Integer
     * Dependencies: N/A
     * Throws/Exception: N/A
     */
    private static int countTotalWords(WordNode node) {
        if (node != null) {
            countTotalWords(node.left);
            totalWordsCounter += node.counter;
            countTotalWords(node.right);
        }
        return totalWordsCounter;
    } // End totalWords()

    /**
     * Method Name: readPrintFile
     * @author Duc Anh Vu
     * Creation Date: April 6, 2021
     * Modified Date: April 9, 2021
     * Description: Read in and print out the text file.
     * @param fileName File input to read and print
     * @return Content of the file in lower case with no punctuation except apostrophe
     * Data Type: String
     * Dependencies: Scanner
     * @throws FileNotFoundException If file not found then throw error
     */
    public static String readPrintFile(String fileName) throws FileNotFoundException {
        String content = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
        System.out.println(content);
        return content.toLowerCase().replace("\"", "").replace(".", " ").replace("-", "")
                .replace(",", "").replace("  ", " ").replace("/", "")
                                    .replace(":", "");
    } // End readPrintFile()

    public static void main(String[] args) {

        // Application header
        System.out.println("========================");
        System.out.println("   File analyzer v1.0   ");
        System.out.println("========================");

        // Load file


        try {
            Scanner loadFile = new Scanner(System.in);
            System.out.println("Please input your file name with extension in:");
            String fileName = loadFile.nextLine();
            System.out.println();

            // Handle file
            System.out.println("Original version:");
            String content = readPrintFile(fileName); // Assign return value of rPFNP() to String content
            contentToWordsBST(content);
            System.out.println();
            System.out.println("No punctuation + lower case version:");
            System.out.println(content);
            System.out.println();

        } catch (FileNotFoundException f) {
            System.out.println();
            System.out.println("File error or not found!");
            System.exit(0);
        }



        // Menu handle
        while (true) {

            // Menu list
            System.out.println("Please input your choice:");
            System.out.println("1: Search for particular word");
            System.out.println("2: Print out alphabetical list of all words");
            System.out.println("3: Quit");

            // Menu cases
            Scanner menuChoice = new Scanner(System.in);
            int input = Integer.parseInt(menuChoice.nextLine());
            switch (input) {
                case 1:
                    System.out.println("Please input the word you want to search:");
                    Scanner searcher = new Scanner(System.in);
                    String wordToSearch = searcher.nextLine().toLowerCase();
                    System.out.println();
                    if (treeContains(root, wordToSearch, 1)) {
                        System.out.println();
                    } else {
                        System.out.println("Item not found");
                        System.out.println();
                    }
                    break;
                case 2:
                    treeList(root);
                    totalWordsCounter = 0;
                    System.out.println("Total words: " + countTotalWords(root));
                    System.out.println("Total nodes: " + countTotalNodes(root));
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    System.out.println("Program exit!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu item does not exist.");
                    System.out.println();
                    break;
            }
        }
    }

    private static class WordNode {
        String word;
        int counter;
        WordNode left;
        WordNode right;
        WordNode(String word) {
            this.word = word;
            counter = 1;
        }
    }
}