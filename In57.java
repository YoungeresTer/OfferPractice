package offerPractice;

/**
 * Created by Meihuan on 2018/4/9.
 */
import java.util.ArrayList;
public class In57 {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        int end = (sum + 1) >> 1;
        int lo = 1;
        int hi = 2;
        int curSum = lo + hi;
        while(lo < end){

            if(curSum == sum){
                ArrayList<Integer> sub = new ArrayList();
                for(int i = lo;i<=hi;i++){
                    sub.add(i);
                }
                res.add(sub);
                hi++;
                curSum += hi;
            }else if(curSum < sum){
                hi++;
                curSum += hi;
                
            }else{
                curSum -= lo;
                lo++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int sum = 9;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res = FindContinuousSequence(sum);
    }
}
