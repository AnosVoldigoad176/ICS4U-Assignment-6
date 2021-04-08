public class Node {

    public static class TreeNode {

        String item;
        TreeNode left;
        TreeNode right;
        TreeNode (String str){
            item = str;

        }
    }

    public static TreeNode root;

    static boolean treeContains (TreeNode root, String item) {
        if (root == null) {
            return false;
        }
        else if (item.equals(root.item) ){
            return true;
        }
        else if (item.compareTo(root.item) < 0 ) {
            return treeContains(root.left, item);
        }
        else {
            return treeContains(root.right, item);
        }
    }

    public void treeInsert (String newItem) {

        if (root == null) {
            root = new TreeNode(newItem);
            return;
        }
        TreeNode runner;
        runner = root;

        while (true){
            if ( newItem.compareTo(runner.item) < 0) {
                if ( runner.left == null) {
                    runner.left = new TreeNode(newItem);
                    return;
                }
                else {
                    runner = runner.right;
                }
            }
        }//End While
    }//End treeInsert



}

