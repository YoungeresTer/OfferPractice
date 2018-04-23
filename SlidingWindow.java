package offerPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by Meihuan on 2018/4/19.
 */
public class SlidingWindow {
    public static ArrayList<Integer> maxInWindows(int [] nums, int size)
    {
        ArrayList<Integer> res = new ArrayList();
        if(nums == null || nums.length < size || size <= 0) return res;
        int len = nums.length;
        PriorityQueue<Integer> win = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i = 0;i<len;i++){
            if(win.size() < size){
                win.offer(nums[i]);
                continue;
            }
            res.add(win.peek());
            win.remove(nums[i-size]);
            win.offer(nums[i]);

        }
        res.add(win.peek());
        return res;
    }

    public static ArrayList<Integer> maxInWindows2(int [] nums, int size){
        ArrayList<Integer> res = new ArrayList();
        if(nums == null || nums.length < size || size <= 0) return res; //特殊输入的考虑
        int len = nums.length;
        LinkedList<Integer> queue = new LinkedList();
        for(int i = 0;i<size;i++){
            while(!queue.isEmpty() && nums[queue.getLast()] <= nums[i]){
                queue.removeLast();
            }
            queue.add(i); //注意这里是添加的索引而不是元素值
        }
        for(int i = size;i<len;i++){
            res.add(nums[queue.getFirst()]);//每次输出一个元素到res
            while(!queue.isEmpty() && nums[queue.getLast()] <= nums[i]){
                queue.removeLast();
            }
            while(queue.getFirst() <= i - size){
                queue.removeFirst();
            }
            queue.add(i);
        }
        res.add(nums[queue.removeFirst()]);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{16,14,12,10,8,6,4};
        int size = 3;
        System.out.println(maxInWindows(nums,size));
        System.out.println(maxInWindows2(nums,size));
    }
}
