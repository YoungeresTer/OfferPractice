package offerPractice;

/**
 * Created by Meihuan on 2018/4/11.
 */
public class In19 {

    public boolean match(char[] str, char[] pattern){
        if(str == null || pattern == null) return false;
        int strlen = str.length;
        int plen = pattern.length;
        if(strlen == plen && strlen == 0) return true;
        return matchCore(str,0,pattern,0);
    }

    private static boolean matchCore(char[] str,int si,char[] pattern,int pi){
        int strlen = str.length;
        int plen = pattern.length;
        if(strlen == si && plen == pi){
            return true;
        }
        if(plen == pi && strlen != si){
            return false;
        }
        if(plen != pi && strlen == si){
            char pnext = '\0';
            if(pi < plen - 1){
                pnext = pattern[pi + 1];
            }
            if(pnext != '*') return false;
            return matchCore(str,si,pattern,pi+2);
        }
        //到这里就代表两者都没有结束
        char scur = str[si];
        char pcur = pattern[pi];
        char pnext = '\0';
        if(pi < plen - 1){
            pnext = pattern[pi + 1];
        }
        if(pnext == '*'){
            //匹配当前值
            if(pcur == scur || pcur == '.'){
                return matchCore(str,si+1,pattern,pi)
                        || matchCore(str,si+1,pattern,pi+2)
                        || matchCore(str,si,pattern,pi+2);
            }else{
                return matchCore(str,si,pattern,pi+2);
            }
        }
        if(pcur == scur || pcur == '.'){
            return matchCore(str,si+1,pattern,pi+1);
        }
        return false;
    }
}
