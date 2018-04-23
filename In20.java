package offerPractice;

/**
 * Created by Meihuan on 2018/4/11.
 */
public class In20 {
    private static int firstSymbolIndex = -1;
    private static int lastNumIndex;

    public static boolean isNumeric(char[] chs) {
        if(chs == null || chs.length <= 0) return false;
        boolean res = false;
        res = isInteger(chs,0);
        int len = chs.length;
        if(firstSymbolIndex != -1 && chs[firstSymbolIndex] == '.'){
            if (firstSymbolIndex == len - 1) return false;
            res = isUnsignedInteger(chs,firstSymbolIndex+1) || res;
        }
        if(firstSymbolIndex != -1 && (chs[firstSymbolIndex] == 'e' || chs[firstSymbolIndex] == 'E')){
            if (firstSymbolIndex == len - 1) return false;
            res = isInteger(chs,firstSymbolIndex+1) && res;
        }
        return (lastNumIndex == chs.length -1) && res;
    }

    public static boolean isUnsignedInteger(char[] chs,int start){
        int len = chs.length;
        if(start >= len) return false;
        boolean flag = false;
        for(int i = start;i < len;i++){
            if(chs[i] < '0' || chs[i] > '9'){
                firstSymbolIndex = i;
                flag = true;
                break;
            }
        }
        if(flag){
            if(firstSymbolIndex == start){
                return false;
            }
            lastNumIndex = firstSymbolIndex - 1;
        }else{
            firstSymbolIndex = -1;
            lastNumIndex = len - 1;
        }

        return true;

    }

    public static boolean isInteger(char[] chs,int start){
        if(chs[start] == '+' || chs[start] == '-'){
            start++;
        }
        return isUnsignedInteger(chs,start);
    }

    public static void main(String[] args) {
        String str = "12e";
        char[] chs = str.toCharArray();
        System.out.println(isNumeric(chs));
    }
}
