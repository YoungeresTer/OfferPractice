package offerPractice;

/**
 * Created by Meihuan on 2018/4/7.
 */
public class In51 {
    private static int[] aux;

    public static int InversePairs(int [] array) {
        if(array == null || array.length <= 1) return 0;
        int len = array.length;
        aux = new int[len];

        return sortAndCalc(array,0,len-1);
    }

    private static int sortAndCalc(int[] array,int start,int end){
        if(start >= end) return 0;
        int count = 0;
        int mid = (start + end) / 2;
        count += sortAndCalc(array,start,mid);
        count += sortAndCalc(array,mid+1,end);
        count += merge(array,start,mid,end);
        return count;
    }

    private static int merge(int[] array,int start,int mid,int end){
        for(int i = start;i<= end;i++){
            aux[i] = array[i];
        }
        int left = mid;
        int right = end;
        int count = 0;
        for(int i = end;i>=start ;i--){
            if(left < start){
                while (right >= mid + 1) array[i--] = aux[right--];
            }else if (right < mid + 1){
                while (left >= start) array[i--] = aux[left--];
            }else if(aux[left] > aux[right]){
                count += right - mid;
                array[i] = aux[left--];
            }else{
                array[i] = aux[right--];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{7,5,6,4,1,2,9,3};
        //int[] nums2 = new int[]{364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        int[] nums2 = new int[]{4,5,6,7};
        int[] nums3 = new int[]{7,6,5,4};
        int[] nums4 = new int[]{4,4,6,6,5};
        int[] nums5 = new int[]{2,1};
        int[] nums6 = new int[]{1};
        int[] nums7 = null;
        System.out.println("nums1 invert pairs = "+InversePairs(nums1));
        printArray(nums1);
        System.out.println("nums2 invert pairs = "+InversePairs(nums2));
        System.out.println("nums2 invert pairs = "+InversePairs(nums2));
        System.out.println("nums3 invert pairs = "+InversePairs(nums3));
        System.out.println("nums4 invert pairs = "+InversePairs(nums4));
        System.out.println("nums5 invert pairs = "+InversePairs(nums5));
        System.out.println("nums6 invert pairs = "+InversePairs(nums6));
        System.out.println("nums7 invert pairs = "+InversePairs(nums7));
    }

    public static void printArray(int[] a){
        if(a == null || a.length == 0) return;
        int length = a.length;
        for(int i = 0;i<length;i++){
            System.out.print(a[i]+",");
        }

    }
}
