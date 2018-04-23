package offerPractice;

/**
 * Created by Meihuan on 2018/4/7.
 */
public class In50 {
    public static int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() <= 0) return -1;
        int len = str.length();
        char[] chs = str.toCharArray();
        int[] counts = new int[52];
        for(int i = 0;i< len;i++){
            char ch = chs[i];
            System.out.println();
            counts[(ch-'A')]++;
        }
        for(int i = 0;i<len;i++){
            char ch = chs[i];
            if(counts[(ch - 'A')] == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
        System.out.println(FirstNotRepeatingChar(str));
    }
}
