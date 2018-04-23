package offerPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Meihuan on 2018/4/16.
 */
public class In32 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if(root == null) return res;
        Stack<TreeNode>[] stacks = new Stack[2];
        stacks[0] = new Stack();
        stacks[1] = new Stack();
        stacks[0].push(root);
        int curStackIndex = 0;
        int nextStackIndex = 1;
        ArrayList<Integer> sub = new ArrayList();
        while(!stacks[0].empty() || !stacks[1].empty()){
            TreeNode node = stacks[curStackIndex].pop();
            sub.add(node.val);
            if(curStackIndex == 0){
                //代表奇数层，先存左节点，再存右节点
                if(node.left != null){
                    stacks[nextStackIndex].push(node.left);
                }
                if(node.right != null){
                    stacks[nextStackIndex].push(node.right);
                }
            }else{
                //代表偶数层，先存右节点，再存左节点
                if(node.right != null){
                    stacks[nextStackIndex].push(node.right);
                }
                if(node.left != null){
                    stacks[nextStackIndex].push(node.left);
                }
            }
            if(stacks[curStackIndex].empty()){
                res.add(new ArrayList<Integer>(sub));
                sub.clear();
                curStackIndex = 1 - curStackIndex;
                nextStackIndex = 1 - curStackIndex;
            }
        }
        return res;
    }


    ArrayList<ArrayList<Integer> > Print2(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList();
        int thisLevel = 1;
        int nextLevel = 0;
        queue.addLast(root);
        ArrayList<Integer> sub = new ArrayList();
        while(queue.size() != 0){
            TreeNode cur = queue.removeFirst();
            sub.add(cur.val);
            thisLevel--;
            if(cur.left != null){
                queue.addLast(cur.left);
                nextLevel++;
            }
            if(cur.right != null){
                queue.addLast(cur.right);
                nextLevel++;
            }
            if(thisLevel == 0){
                res.add(new ArrayList<Integer>(sub));
                sub.clear();
                thisLevel = nextLevel;
                nextLevel = 0;
            }
        }
        return res;
    }
}
