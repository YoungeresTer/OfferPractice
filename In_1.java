package offerPractice;

import java.util.ArrayList;

/**
 * Created by Meihuan on 2018/4/12.
 */
public class In_1 {

    private static int[] count = new int[128];
    private static ArrayList<Character> data = new ArrayList();

    //Insert one char from stringstream
    public static void Insert(char ch)
    {
        count[ch]++;
        if(data.isEmpty() || count[ch] == 1){
            data.add(ch); //data本身就维护了输入流的顺序
        }
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
        while(!data.isEmpty()){
            if(count[data.get(0)] == 1){
                return data.get(0);
            }else{
                data.remove(0);
            }

        }
        return '#';
    }

    public static void main(String[] args) {
        String str = "hellhworld";
        char[] chs = str.toCharArray();
        for (int i = 0;i < chs.length;i++){
            Insert(chs[i]);
            System.out.print(FirstAppearingOnce() + " ");
        }
    }
}
