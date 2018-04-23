package offerPractice;

/**
 * Created by Meihuan on 2018/4/6.
 */
public class In36 {
    private static TreeNode2 lastNodeInList = null;

    public static TreeNode2 Convert(TreeNode2 root) {
        if(root == null) return null;
        lastNodeInList = null;
        convertNode(root);
        while(lastNodeInList.left != null){
            lastNodeInList = lastNodeInList.left;
        }
        return lastNodeInList;
    }

    private static void convertNode(TreeNode2 root){
        if(root.left != null){
            convertNode(root.left);
        }
        root.left = lastNodeInList;
        if(lastNodeInList != null){
            lastNodeInList.right = root;
        }
        lastNodeInList = root;
        if(root.right != null){
            convertNode(root.right);
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode2 node7 = new TreeNode2(4, null, null);
        TreeNode2 node6 = new TreeNode2(8, null, null);
        TreeNode2 node5 = new TreeNode2(12, null, null);
        TreeNode2 node4 = new TreeNode2(16, null, null);
        TreeNode2 node3 = new TreeNode2(6, node7, node6);
        TreeNode2 node2 = new TreeNode2(14, node5, node4);
        TreeNode2 node1 = new TreeNode2(10, node3, node2);

        TreeNode2 nodeLeft2 = new TreeNode2(6, node7, null);
        TreeNode2 nodeLeft1 = new TreeNode2(10, nodeLeft2, null);

        TreeNode2 nodeSingle = new TreeNode2(0, null, null);

        TreeNode2 nodeNull = null;

        TreeNode2 newNode5 = new TreeNode2(1,null,null);
        TreeNode2 newNode4 = new TreeNode2(2,newNode5,null);
        TreeNode2 newNode3 = new TreeNode2(3,newNode4,null);
        TreeNode2 newNode2 = new TreeNode2(4,newNode3,null);
        TreeNode2 newNode1 = new TreeNode2(5,newNode2,null);


        TreeNode2 result = null;
        result = Convert(newNode1); //注意这里的convert函数会改变原始的二叉搜索树的结构
		/*result = convert(nodeLeft1);
		result = convert(nodeSingle);
		result = convert(nodeNull);*/
    }
}

class TreeNode2 {
    int val = 0;
    TreeNode2 left = null;
    TreeNode2 right = null;

    public TreeNode2(int val) {
        this.val = val;

    }

    public TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
