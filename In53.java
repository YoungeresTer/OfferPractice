package offerPractice;

/**
 * Created by Meihuan on 2018/4/8.
 */
public class In53 {
    private static int maxDepth;
    private static int curDepth;

    public static int treeDepth(TreeNode root) {
        if(root == null) return 0;
        maxDepth = 0;
        curDepth = 0;
        treeDepthCore(root);
        return maxDepth;
    }

    private static void treeDepthCore(TreeNode root){
        curDepth++;
        if(root.left == null && root.right == null){
            maxDepth = (maxDepth < curDepth)?curDepth:maxDepth;
            //curDepth--;
            return;
        }
        if(root.left != null){
            treeDepthCore(root.left);
            curDepth--;
        }

        if(root.right != null){
            treeDepthCore(root.right);
            curDepth--;
        }

    }

    private static int treeDepth1(TreeNode root){
        if(root == null) return 0; //递归终止条件
        int leftDepth = treeDepth1(root.left); //利用递归进行求解
        int rightDepth = treeDepth1(root.right);
        return (leftDepth > rightDepth)?(leftDepth + 1):(rightDepth + 1); //返回左右子树中的值的较大者+1
    }

    public static void main(String[] args) {
        TreeNode node8 = new TreeNode(10, null, null);
        TreeNode node7 = new TreeNode(2, node8, null);
        TreeNode node6 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(6, null, null);
        TreeNode node4 = new TreeNode(8, null, null);
        TreeNode node3 = new TreeNode(3, node7, node6);
        TreeNode node2 = new TreeNode(7, node5, node4);
        TreeNode node1 = new TreeNode(5, node3, node2);
        TreeNode node0 = new TreeNode(0, node1, null);

        TreeNode nodeLeft5 = new TreeNode(5,null,null);
        TreeNode nodeLeft4 = new TreeNode(4, nodeLeft5, null);
        TreeNode nodeLeft3 = new TreeNode(3, nodeLeft4, null);
        TreeNode nodeLeft2 = new TreeNode(2, nodeLeft3, null);
        TreeNode nodeLeft1 = new TreeNode(1, nodeLeft2, null);

        TreeNode nodeSingle = new TreeNode(0, null, null);
        TreeNode nodeNull =null;

        System.out.println("node1 tree depth is "+treeDepth(node1));
        System.out.println("node1 tree depth is "+treeDepth1(node1));
        System.out.println("nodeLeft1 tree depth is "+treeDepth(nodeLeft1));
        System.out.println("nodeLeft1 tree depth is "+treeDepth1(nodeLeft1));
        System.out.println("nodeSingle tree depth is "+treeDepth(nodeSingle));
        System.out.println("nodeSingle tree depth is "+treeDepth1(nodeSingle));
        System.out.println("nodeNull tree depth is "+treeDepth(nodeNull));
        System.out.println("nodeNull tree depth is "+treeDepth1(nodeNull));
    }
}
