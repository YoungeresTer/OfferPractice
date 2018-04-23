package offerPractice;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Meihuan on 2018/4/18.
 */
public class In41 {
    private static int count = 0;
    private static PriorityQueue<Integer> maxPQ = new PriorityQueue(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    private static PriorityQueue<Integer> minPQ = new PriorityQueue();

    //主要需要将流中的数据保存到一个数据结构中，然后再每插入一个元素，调用一次insert和getMidian获取当前的中位数是多少
    public void Insert(Integer num) {
        count++;
        if((count & 1) == 1){
            //代表是奇数，插入到最小堆
            maxPQ.offer(num);
            minPQ.offer(maxPQ.poll());
        }else{
            //如果是偶数，则插入到最大堆
            minPQ.offer(num);
            maxPQ.offer(minPQ.poll());
        }
    }

    public Double GetMedian() {
        if((count & 1) == 1){
            return (double)minPQ.peek();
        }else{
            return (minPQ.peek() + maxPQ.peek()) / 2.0;
        }
    }
}