import javax.swing.tree.TreeNode;

public class Test3 {
    public boolean isBalance(TreeNode root) {
        if ( root == null ) {
            return true;
        }
        int leftHeight = getTreeHeight(root.left);
        int rightHeight = getTreeHeight(root.right);

        if ( Math.abs(leftHeight - rightHeight) > 1 ) {
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
        public static int getTreeHeight(TreeNode root) {
        if ( root == null ) {
            return false;
        }
        return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;
    }
}
