/*
package offerPractice;

*/
/**
 * Created by Meihuan on 2018/3/28.
 *//*

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {

    private static final String carSplit =";";
    private static final String timeSplit =",";
    private static final String regress = "(\\d{1,2},\\d{1,2};)*\\d{1,2},\\d{1,2}$";

    public static void main(String[] args) {
        String inString = null;
        // 数据输入
        Scanner in = new Scanner(System.in);
        inString = in.nextLine();
        //字符串数组格式校验
        Pattern pat = Pattern.compile(regress);
        if(inString == null || inString.trim().equals("")||!pat.matcher(inString).matches()){
            System.out.println("输入错误!");
            return;
        }
        Main sol = new Main();
        int countCars = sol.countCars(sol.convertToArray(inString));
        System.out.println(countCars);
    }

    //输入字符串转数组
    public int[][] convertToArray(String str) {
        String[] strArray = str.split(carSplit);
        int row = strArray.length;
        int col = 2;
        // 字符转数组判断
        int[][] carArray = new int[row][col];
        int start,end;
        for (int i = 0; i < row; i++) {
            start = Integer.parseInt(strArray[i].split(timeSplit)[0]);
            end = Integer.parseInt(strArray[i].split(timeSplit)[1]);
            if(start>end){
                continue;
            }
            carArray[i][0] = start;
            carArray[i][1] = end;
        }
        return carArray;
    }
    public int countCars(int[][] carArray) {
        int ans = 0;
        if(carArray == null || carArray.length <= 0) return 0;
        int len = carArray.length;
        int[] arrTime = new int[len];
        int[] leaveTime = new int[len];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<len;i++){
            arrTime[i] = carArray[i][0];
            leaveTime[i] = carArray[i][1];
            map.put(arrTime[i],leaveTime[i]);
        }
        Arrays.sort(arrTime);
        int[] counts = new int[];
        for (int i = 0;i<12;i++){
            int count = 0;
            int index = binarySerach(i,arrTime); //找到这个index
            for (int j = 0;j<arrTime[index];j++){

                Object value = map.get(j);
                if(value != null){
                    if (value)
                }
            }
        }
        return ans; // 返回计算结果
    }

    public static int binarySerach(int target, int[] nums){
        if (nums == null || nums.length <= 0) return -1;
        int len = nums.length;
        int lo = 0;
        int hi = len - 1;
        int mid = 0;
        while(lo <= hi){ //注意这里必须是<=，否则在边缘的数字找不到的。(这个是最核心的部分)
            mid = (lo + hi) / 2;
            if (nums[mid] == target) return mid; //返回的是下标
            else if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return (lo - 1); //返回的-1代表在数组中找不到该元素
    }
}

class Node{
    int index;
    int val;

    public Node(int index, int val) {
        this.index = index;
        this.val = val;
    }
}*/
