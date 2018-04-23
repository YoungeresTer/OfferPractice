package offerPractice;

/**
 * Created by Meihuan on 2018/4/18.
 */
public class In54 {
    private static int k;

    static TreeNode KthNode(TreeNode root, int ks)
    {
        if(root == null || ks <= 0) return null; //暂时没有考虑k大于树的节点个数的情况
        k = ks;
        return kthNodeCore(root);
    }

    private static TreeNode kthNodeCore(TreeNode root){
        TreeNode target = null;
        if(root.left != null){
            target = kthNodeCore(root.left);
        }
        if(target == null){
            if(k == 1){
                target = root;
            }else{
                k--;
            }
        }
        if(target == null && root.right != null){
            target = kthNodeCore(root.right);
        }
        return target;
    }

    public static void main(String[] args) {
        TreeNode n7 = new TreeNode(11);
        TreeNode n6 = new TreeNode(9);
        TreeNode n5 = new TreeNode(7);
        TreeNode n4 = new TreeNode(5);
        TreeNode n3 = new TreeNode(10,n6,n7);
        TreeNode n2 = new TreeNode(6,n4,n5);
        TreeNode n1 = new TreeNode(6,n2,n3);

        TreeNode reas = KthNode(n1,2);
    }
}