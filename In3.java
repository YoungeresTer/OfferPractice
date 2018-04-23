package offerPractice;

/**
 * Created by Meihuan on 2018/4/10.
 */
public class In3 {

    public static boolean duplicate(int nums[],int length,int [] duplication) {
        if(nums == null || length <= 0) return false;
        int len = length;
        /*for(int i = 0;i<len;i++){
            if(nums[i] < 0 || nums[i] > len-1) return false;
        }*/
        for(int i = 0; i < len;i++){
            while(nums[i] != i){
                if(nums[nums[i]] == nums[i]){
                    duplication[0] = nums[i];
                    return true;
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,3,1,0,2,5,3};
		int[] nums2 = null;
		int[] nums3 = new int[]{2,3,1,0,5,4};
		int[] res = new int[1];
		boolean flag = duplicate(nums1,nums1.length,res);
		System.out.println(flag + ", " + res[0]);
    }
}
