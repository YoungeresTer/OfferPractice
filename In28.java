package offerPractice;

import java.util.ArrayList;

/**
 * Created by Meihuan on 2018/4/16.
 */
public class In28 {
    static boolean isSymmetrical1(TreeNode root)
    {
        if(root == null) return false;
        TreeNode rootCopy = copyTree(root);
        root = mirrorTree(root);
        return isTwoTreeEqual(root,rootCopy);
    }

    private static TreeNode mirrorTree(TreeNode root){
        /*if(root.left == null && root.right == null) return root;
        TreeNode right = null;
        if(root.left != null){
            TreeNode left = root.left;
            if (root.right != null){
                right = root.right;
            }
            root.right = mirrorTree(left);
        }
        if(right != null){
            root.left = mirrorTree(right);
        }
        return root;*/
        if(root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = mirrorTree(left);
        root.left = mirrorTree(right);
        return root;
    }

    private static boolean isTwoTreeEqual(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if((root1 == null && root2 != null) || (root2 == null && root1 != null)) return false;
        if(root1.val != root2.val) return false;
        return isTwoTreeEqual(root1.left,root2.left) && isTwoTreeEqual(root1.right,root2.right);
    }

    private static TreeNode copyTree(TreeNode root){
        if(root.left == null && root.right == null) return new TreeNode(root.val);
        TreeNode rootCopy = new TreeNode(root.val);
        if(root.left != null){
            rootCopy.left = copyTree(root.left);
        }
        if(root.right != null){
            rootCopy.right = copyTree(root.right);
        }
        return rootCopy;
    }

    public static void main(String[] args) {
        TreeNode symNode7 = new TreeNode(5, null, null);
        TreeNode symNode6 = new TreeNode(7, null, null);
        TreeNode symNode5 = new TreeNode(7, null, null);
        TreeNode symNode4 = new TreeNode(5, null, null);
        TreeNode symNode3 = new TreeNode(6, symNode7, symNode6);
        TreeNode symNode2 = new TreeNode(6, symNode5, symNode4);
        TreeNode symNode1 = new TreeNode(8, symNode3, symNode2);

        TreeNode nsymNode7 = new TreeNode(5, null, null);
        TreeNode nsymNode6 = new TreeNode(7, null, null);
        TreeNode nsymNode5 = new TreeNode(7, null, null);
        TreeNode nsymNode4 = new TreeNode(5, null, null);
        TreeNode nsymNode3 = new TreeNode(6, nsymNode7, nsymNode6);
        TreeNode nsymNode2 = new TreeNode(9, nsymNode5, nsymNode4);
        TreeNode nsymNode1 = new TreeNode(8, nsymNode3, nsymNode2);

        TreeNode nsymNodeSame6 = new TreeNode(7, null, null);
        TreeNode nsymNodeSame5 = new TreeNode(7, null, null);
        TreeNode nsymNodeSame4 = new TreeNode(7, null, null);
        TreeNode nsymNodeSame3 = new TreeNode(7, nsymNodeSame6, nsymNodeSame5);
        TreeNode nsymNodeSame2 = new TreeNode(7, nsymNodeSame4, null);
        TreeNode nsymNodeSame1 = new TreeNode(7, nsymNodeSame3, nsymNodeSame2);

        TreeNode nullNode = null;
        TreeNode singleNode = new TreeNode(0, null, null);

        TreeNode testLeftNode1 = new TreeNode(1);
        TreeNode testLeftNode2 = new TreeNode(2,testLeftNode1,null);
        TreeNode testLeftNode3 = new TreeNode(3,testLeftNode2,null);
        TreeNode testLeftNode4 = new TreeNode(4,testLeftNode3,null);
        TreeNode testRightNode1 = new TreeNode(1);
        TreeNode testRightNode2 = new TreeNode(2,null,testRightNode1);
        TreeNode testRightNode3 = new TreeNode(3,null,testRightNode2);
        TreeNode testRightNode4 = new TreeNode(4,null,testRightNode3);
        TreeNode testLeftNode5 = new TreeNode(5,testLeftNode4,testRightNode4);


        System.out.println("test node .." + isSymmetrical(testLeftNode5));
        System.out.println("is synNode1 symmertical? "+isSymmetrical(symNode1));
        System.out.println("is nsynNode1 symmertical? "+isSymmetrical(nsymNode1));
        System.out.println("is nsynNodeSame1 symmertical? "+isSymmetrical(nsymNodeSame1));
        System.out.println("is nullNode symmertical? "+isSymmetrical(nullNode));
        System.out.println("is singleNode symmertical? "+isSymmetrical(singleNode));
    }

    static boolean isSymmetrical(TreeNode root){
        if(root == null) return true;
        ArrayList<Integer> res1 = new ArrayList();
        ArrayList<Integer> res2 = new ArrayList();
        PreOrderIncludeNull(root,res1);
        PreOrderIncludeNullInverse(root,res2);
        return compareTwoList(res1,res2);
    }

    private static void PreOrderIncludeNull(TreeNode root,ArrayList<Integer> res){
        if(root == null) {
            res.add(null);
            return;
        }
        res.add(root.val);
        PreOrderIncludeNull(root.left,res);
        PreOrderIncludeNull(root.right,res);
    }

    private static void PreOrderIncludeNullInverse(TreeNode root,ArrayList<Integer> res){
        if(root == null) {
            res.add(null);
            return;
        }
        res.add(root.val);
        PreOrderIncludeNullInverse(root.right,res);
        PreOrderIncludeNullInverse(root.left,res);
    }

    private static boolean compareTwoList(ArrayList<Integer> res1,ArrayList<Integer> res2){
        if(res1.size() != res2.size()) return false;
        while(res1.get(res1.size()-1) == res2.get(res2.size()-1)){
            res1.remove(res1.size()-1);
            res2.remove(res2.size()-1);
        }
        if(!res1.isEmpty()) return false;
        return true;
    }
}
