/*
 * Author: Anos Voldigoad
 * Last modified: April 8, 2021
 * Description: Analyze text file using ADT concept.
 */

public class WordTree {

    private static class WordNode {
        String word;
        int counter;
        WordNode left;
        WordNode right;
        WordNode(String word, int counter) {
            word = word;
            counter = counter;
        }
    }

    private static WordNode root;

    static boolean treeContains(WordNode root, String word, int counter) {
        if (root == null) {
            // Tree is empty, so it certainly doesn't contain item.
            return false;
        }
        else if (word.equals(root.word)) {
            // Yes, the item has been found in the root node.
            return true;
        }
        else if (word.compareTo(root.word) < 0) {
            // If the item occurs, it must be in the left subtree.
            return treeContains(root.left, word, counter + 1);
        }
        else {
            // If the item occurs, it must be in the right subtree.
            return treeContains(root.right, word, counter + 1);
        }
    }  // end treeContains()


    private static void treeList(WordNode node) {
        if ( node != null ) {
            treeList(node.left);             // Print items in left subtree.
            System.out.println("  " + node.word + node.counter);  // Print item in the node.
            treeList(node.right);            // Print items in the right subtree.
        }
    } // end treeList()

}