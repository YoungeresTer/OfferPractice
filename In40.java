package offerPractice;

/**
 * Created by Meihuan on 2018/4/6.
 */
import java.util.*;
public class In40 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] nums, int k) {
        ArrayList<Integer> res = new ArrayList();
        if(nums == null || nums.length <= 0 || nums.length < k || k <= 0) return res;
        int len = nums.length;
        int index = partition(nums,0,len-1);
        while(index != (k-1)){
            if(index > k-1){
                index =  partition(nums,0,index-1);
            }else{
                index = partition(nums,index + 1,len-1);
            }
        }
        for(int i = 0;i<=index;i++){
            res.add(nums[i]);
        }
        return res;
    }

    private static int partition(int[] nums,int start,int end){
        int target = nums[start];
        int lo = start;
        int hi = end + 1;
        while(true){
            while(nums[lo++] <= target) if(lo >= end) break;
            while(nums[--hi] > target) if(end <= start) break;
            if(lo >= hi) break;
            exch(nums,lo,hi);
        }
        exch(nums,start,hi);
        return hi;
    }

    private static void exch(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums1 = new int[]{4,5,1,6,2,7,3,8};
        int[] nums2 = new int[]{4,5,1,6,2,7,3,3};
        int[] nums3 = null;
        int k1 = 4;
        int k2 = 1;
        int k3 = nums1.length;
        int k4 = 0;
        int k5 = k3+1;
        ArrayList<Integer> result = null;
		System.out.println("test nums1...");
		result = GetLeastNumbers_Solution(nums1, k1);
		result = GetLeastNumbers_Solution(nums1, k2);
		result = GetLeastNumbers_Solution(nums1, k3);
		result = GetLeastNumbers_Solution(nums1, k4);
		result = GetLeastNumbers_Solution(nums1, k5);
		System.out.println("test nums2...");
		result = GetLeastNumbers_Solution(nums2, k1);
		System.out.println("test nums3...");
		result = GetLeastNumbers_Solution(nums3, k1);

        //System.out.println("test method2....");
        //System.out.println("test nums1...");
        //result = getLeastNumbers(nums1, k1);
        //result = getLeastNumbers(nums1, k2);
        //result = getLeastNumbers(nums1, k3);
        //result = getLeastNumbers(nums1, k4);
        //result = getLeastNumbers(nums1, k5);
		/*System.out.println("test nums2...");
		result = getLeastNumbers(nums2, k1);
		System.out.println("test nums3...");
		result = getLeastNumbers(nums3, k1);*/
    }
}