package offerPractice;

/**
 * Created by Meihuan on 2018/3/28.
 */
/*public class Solution {
    public String replaceSpace(StringBuffer str) {
        if(str == null || str.length() <= 0) return str == null? null : str.toString();
        char[] chsori  = str.toString().toCharArray();
        int count = 0;
        for (int i = 0; i < chsori.length; i++){
            if (chsori[i] == ' '){
                count++;
            }
        }
        char[] chsnew = new char[chsori.length + count * 2];
        int newIndex = chsnew.length - 1;
        for (int i = chsori.length - 1;i>=0;i--){
            if (chsori[i] != ' ') chsnew[newIndex--] = chsori[i];
            else{
                chsnew[newIndex--] = '0';
                chsnew[newIndex--] = '2';
                chsnew[newIndex--] = '%';
            }
        }
        return new String(chsnew);
    }
}*/

import java.util.Arrays;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*public class Solution {
    public TreeNode1 reConstructBinaryTree(int [] pre, int [] in) {
        if(pre == null ||in == null || pre.length != in.length) return null;
        return constrctSingleTree(pre,in,0,pre.length - 1,0,in.length - 1);

    }

    public TreeNode1 constrctSingleTree(int[] pre,int[] in,int prelo, int prehi,int inlo,int inhi){
        if(prelo > prehi) return null;
        else if(inlo > inhi) return null;
        else{
            TreeNode1 inHead = new TreeNode1(pre[prelo]);
            int inHeadIndex = 0;
            for(int i = inlo;i<=inhi;i++){
                if(in[i] == pre[prelo]){
                    inHeadIndex = i;
                    break;
                }
            }
            int leftNodeLen = inHeadIndex - inlo;
            int rightNodeLen = inhi - inHeadIndex;
            inHead.left = constrctSingleTree(pre,in,prelo + 1,prelo + leftNodeLen,inlo,inHeadIndex - 1);
            inHead.right = constrctSingleTree(pre,in,prehi - rightNodeLen + 1,prehi,inHeadIndex + 1,inhi);
            return inHead;
        }

    }

    public static void main(String[] args) {
        int[] preorder = new int[]{1,2,4,7,3,5,6,8};
        int[] inorder = new int[]{4,7,2,1,5,3,8,6};
        TreeNode1 head = new Solution().reConstructBinaryTree(preorder, inorder);
        System.out.println(head.val);
        System.out.println(head.left.val);
    }
}

 class TreeNode1 {
      int val;
      TreeNode1 left;
      TreeNode1 right;
      TreeNode1(int x) { val = x; }
  }*/

public class Solution {

    public int NumberOf1(int n) {
        int count = 0;
        int x = 1;
        for(int i = 0;i<32;i++){
            if((n & x) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void reOrderArray(int [] array) {
        if(array == null || array.length <= 0) return;
        int len = array.length;
        int[] res = new int[len];
        int index = 0;
        for(int i = 0;i<len;i++){
            if(array[i] % 2 == 1) res[index++] = array[i];
        }
        for(int i = 0;i<len;i++){
            if(array[i] % 2 == 0) res[index++] = array[i];
        }
        System.out.println("res");
        printArray(res);
        System.out.println();
        array = Arrays.copyOf(res,len);
    }

    public static double Power(double base, int exponent) {
        //return Math.pow(base,exponent);
        int newExponent = 0;
        if (exponent < 0) {
            if (base <= 0) throw new RuntimeException("指数为负数的情况下base不能是非正数");
            else newExponent = (-1) * exponent;
        } else if (exponent == 0) return 1;
        else newExponent = exponent;
        System.out.println(exponent);
        System.out.println(newExponent);
        int res = 1;
        if (newExponent != 0) {
            while (newExponent != 0) {
                if ((newExponent & 1) == 1) {
                    res *= base;
                }
                base *= base; //注意这里要翻倍
                newExponent = newExponent >> 1;
            }
        }
        System.out.println(res);
        return exponent > 0 ? res : (1.0 / res);
    }

    //根据给出的前序遍历和中序遍历的数组，重建二叉树
    public static TreeNode construstTree(int[] pre,int[] in) throws Exception{
        if(pre == null || in == null || pre.length == 0 || in.length == 0){
            return null;
        }
        int prestart = 0;
        int preend = pre.length-1;
        int instart = 0;
        int inend = in.length - 1;
        TreeNode head = constustRootTree(prestart,preend,instart,inend,pre,in);
        return head; //最终返回头结点
    }
    //根据指定范围的前序数组和中序数组建立一个根节点和其两个子节点的子树结构
    public static TreeNode constustRootTree(int prestart,int preend, int instart,int inend,int[] preorder,int[] inorder) throws Exception{

        //根节点为前序数组中的第一个元素
        TreeNode root = new TreeNode(preorder[prestart], null, null);
        //递归结束条件
        if(instart >= inend){
            //表明该子树已经没有节点了
            if(prestart >= preend) return root; //注意这边返回的是叶节点
            else throw new Exception(); //注意这里也可能输入的不是合理项
        }
        int inrootIndex = -1; //这个变量代表在中序数组中的根节点的index
        //在中序数组中查找对应的root节点的位置
        for(int i = instart;i<=inend;i++){
            if(inorder[i] == root.val){
                //表明找到了该index
                inrootIndex = i;
            }
        }
        if(inrootIndex == -1){
            //表明没有找到对应在中序数组中的root节点
            throw new Exception();
        }
        //计算左子树和右子树的长度
        int leftTreeLen = inrootIndex - instart;
        int rightTreeLen = inend - inrootIndex;
        int preLeftTreeStartIndex = (leftTreeLen>0)?prestart + 1:prestart; //注意这里需要判断长度，否则+1会出现问题
        int preLeftTreeEndIndex = prestart + leftTreeLen;
        int preRightTreeStartIndex = (rightTreeLen>0)?preLeftTreeEndIndex + 1:preLeftTreeEndIndex; //注意这里需要判断长度，否则+1会出现问题
        int preRightTreeEndIndex = preend;
        if(leftTreeLen > 0){
            //表明还有左子树，进行挂载
            root.left = constustRootTree(preLeftTreeStartIndex, preLeftTreeEndIndex, instart, inrootIndex-1, preorder, inorder);
        }
        if(rightTreeLen > 0){
            //表明还有右子树，进行挂载
            root.right = constustRootTree(preRightTreeStartIndex, preRightTreeEndIndex, inrootIndex + 1, inend, preorder, inorder);
        }
        return root; //注意最终需要返回节点给上层的父节点
    }




    public static void printArray(int[] a){
        if(a == null || a.length == 0) return;
        int length = a.length;
        for(int i = 0;i<length;i++){
            System.out.print(a[i]+",");
        }

    }

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode head = null;
        ListNode cur1 = null;
        ListNode cur2 = null;
        if(list1.val < list2.val) {
            head = list1;
            cur1 = list1.next;
            cur2 = list2;
        }
        else {
            head = list2;
            cur2 = list2.next;
            cur1 = list1;
        }
        ListNode res = head;
        while(cur1 != null && cur2 != null){
            int val1 = cur1.val;
            int val2 = cur2.val;
            if(val1 < val2){

                head.next = cur1;
                cur1 = cur1.next;
            }else{
                head.next = cur2;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        while (cur1 != null){
            head.next = cur1;
            cur1 = cur1.next;
            head = head.next;
        }
        while(cur2 != null){
            head.next = cur2;
            cur2 = cur2.next;
            head = head.next;
        }
        return res;
    }

    //数的子结构：即判断一棵树B是否是另外一颗树A的子树:1.先找到A中跟Bhead相同的节点（递归中序遍历） 2.在这个基础上判断其下面的子树是否相同（递归判断）
    private static boolean hasSubTree(BinaryTreeNode head1,BinaryTreeNode head2){
        if(head1 == null || head2 == null) return false; //如果两课子树中存在一棵是null,那么直接返回false，同时也是递归的终止条件
        boolean result = false;
        if(head1!=null && head2!=null){
            //当两棵树都不为空时，找到head1中的head2值
            if(head1.value == head2.value){
                //表明两个根节点相同
                result = doesTree1HaveTree2(head1,head2); //里层递归
            }
            if(!result){ //注意这个判断的条件跟前面的result的结果是密切相关的
                //表明没有找到子树，继续下一个节点的遍历,采用中序遍历的思想
                result = hasSubTree(head1.left, head2); //外层递归
            }
            if(!result){
                result = hasSubTree(head1.right, head2);
            }
        }
        return result;
    }

    private static boolean doesTree1HaveTree2(BinaryTreeNode head1, BinaryTreeNode head2) {
        // TODO Auto-generated method stub
        if(head2 == null) return true; //代表的是head2中的节点已经全部匹配完，则返回true
        if(head1 == null) return false;//表明head1为空，但是head2不为空，表明head1的叶节点对应了head2的非叶节点
        //这是两边都不为空的情况
        if(head1.value != head2.value) return false; //这是因为需要递归使用这个函数，所以也可能出现这种情况
        //到这里表示head1节点和head2节点相同，则继续下一层的判断
        return doesTree1HaveTree2(head1.left, head2.left) && doesTree1HaveTree2(head1.right, head2.right); //只有当下面的两个子节点都为true的时候才会返回true
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //使用<=>符号对double类型进行比较的操作注意事项：
		/*
		 * 1.对于小数点后小于15位的double类型，可以直接像整数一样比较大小
		 * 2.对于超过15位的情况，只比较前面15位的大小，因为存在精度问题
		 * */
        //测试用例：
		/*double a = 0.0100000005410113125410113125410113121312;
		double b = 0.0100000005410113125410113125410113121312;
		boolean flag = (a==b)? true:false; //直接使用==是可以比较的，但是精度，即小数点后面不能超过15位，否则会出错
		System.out.println("a=b?"+" "+flag);
		System.out.println(0.05+0.01);
		double c = 0.05 + 0.01;
		double d = 0.06;
		System.out.println("d = "+d);
		System.out.println("c = d?"+(c==d));
		System.out.println(123.3/100);
		System.out.println(4.015*100);
		System.out.println(1.0-0.42);

		double a1=3.2222222222222221;  15
		double b1=3.2222222222222221;15

        for(int i=0;i<10;i++){

            System.out.print(a1<b1);
            System.out.print(" ");
            System.out.print(a1>b1);
            System.out.print(" ");
            System.out.println(a1==b1);

        }*/
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(2, node6, node7);
        BinaryTreeNode node4 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(8, node4, node5);
        BinaryTreeNode node2 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node1 = new BinaryTreeNode(8, node3, node2);

        BinaryTreeNode nodeB3 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode nodeB2 = new BinaryTreeNode(2, null, null);
        BinaryTreeNode nodeB1 = new BinaryTreeNode(8, nodeB3, nodeB2);

        BinaryTreeNode nodeB3Not = new BinaryTreeNode(9, null, null);
        BinaryTreeNode nodeB2Not = new BinaryTreeNode(3, null, null);
        BinaryTreeNode nodeB1Not = new BinaryTreeNode(8, nodeB3Not, nodeB2Not);

        BinaryTreeNode nodeLeftA3 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode nodeLeftA2 = new BinaryTreeNode(8, nodeLeftA3, null);
        BinaryTreeNode nodeLeftA1 = new BinaryTreeNode(8, nodeLeftA2, null);

        BinaryTreeNode nodeLeftB2 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode nodeLeftB1 = new BinaryTreeNode(8, nodeLeftB2, null);

        BinaryTreeNode nodeLeftB2Not = new BinaryTreeNode(7, null, null);
        BinaryTreeNode nodeLeftB1Not = new BinaryTreeNode(8, nodeLeftB2Not, null);

        BinaryTreeNode nodeNullA = null;
        BinaryTreeNode nodeNullB = null;

        System.out.println("node1 has nodeB1? "+hasSubTree(node1, nodeB1));
        System.out.println("node1 has nodeB1Not? "+hasSubTree(node1, nodeB1Not));
        System.out.println("node1 has nodeNullB? "+hasSubTree(node1, nodeNullB));

        System.out.println("nodeLeftA1 has nodeLeftB1? "+hasSubTree(nodeLeftA1, nodeLeftB1));
        System.out.println("nodeLeftA1 has nodeLeftB1Not? "+hasSubTree(nodeLeftA1, nodeLeftB1Not));
        System.out.println("nodeLeftA1 has nodeNullB? "+hasSubTree(nodeLeftA1, nodeNullB));

        System.out.println("nodeNullA has nodeB1? "+hasSubTree(nodeNullA, nodeB1));
        System.out.println("nodeNullA has nodeB1Not? "+hasSubTree(nodeNullA, nodeB1Not));
        System.out.println("nodeNullA has nodeNullB? "+hasSubTree(nodeNullA, nodeNullB));

    }

    public static void main1(String[] args) throws Exception {
        // TODO Auto-generated method stub
        /*int[] preorder = new int[]{1,2,4,7,3,5,6,8};
        int[] inorder = new int[]{4,7,2,1,5,3,8,6};
        TreeNode head = construstTree(preorder, inorder);
        System.out.println(head.value);
        System.out.println(head.left.value);*/
        //System.out.println(Power(2,-3));
        /*int[] array = new int[]{1,2,3,4,5,6,7};
        printArray(array);
        System.out.println();
        reOrderArray(array);
        printArray(array);*/
        ListNode node3 = new ListNode(6, null);
        ListNode node2 = new ListNode(4, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode nodeN3 = new ListNode(5, null);
        ListNode nodeN2 = new ListNode(3, nodeN3);
        ListNode nodeN1 = new ListNode(1, nodeN2);
        ListNode nodeE3 = new ListNode(6, null);
        ListNode nodeE2 = new ListNode(4, nodeE3);
        ListNode nodeE1 = new ListNode(2, nodeE2);
        ListNode nodeNull = null;
        ListNode nodeNull2 = null;
        ListNode nodeSingle = new ListNode(0, null);
        ListNode nodeSingle2 = new ListNode(2, null);
        ListNode node = null;

        node = Merge(node1, nodeN1);
        //node = merge(node1, nodeNull);
        //node = merge(node1, nodeE1);
        //node = merge(node1, nodeSingle);

        //node = merge(nodeNull, nodeNull2);
        //node = merge(nodeNull, nodeSingle);

        //node = Merge(nodeSingle, nodeSingle2);
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) return false;
        boolean result = false;
        if(root1.val == root2.val){
            result = doesTree1HasTree2(root1,root2);
        }
        if(!result){
            result = HasSubtree(root1.left,root2);
        }
        if(!result){
            result = HasSubtree(root1.right,root2);
        }
        return result;
    }

    private boolean doesTree1HasTree2(TreeNode node1,TreeNode node2){
        if(node2 == null) return true;
        if(node1 == null) return false;
        if(node1.val != node2.val) return false;
        return doesTree1HasTree2(node1.left,node2.left) && doesTree1HasTree2(node1.right,node2.right);
    }

}

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value, TreeNode left, TreeNode right) {
        super();
        this.val = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val){
        this.val = val;
    }
}

class BinaryTreeNode{
    double value;
    BinaryTreeNode left;
    BinaryTreeNode right;
    public BinaryTreeNode(double value, BinaryTreeNode left, BinaryTreeNode right) {
        super();
        this.value = value;
        this.left = left;
        this.right = right;
    }

}



