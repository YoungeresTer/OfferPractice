package offerPractice;

/**
 * Created by Meihuan on 2018/4/19.
 */
public class In12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix == null || matrix.length <= 0 || str == null || str.length <= 0) return false;
        char[][] chs = new char[rows][cols];
        int index = 0;
        int[][] visit = new int[rows][cols];
        for(int i = 0;i<rows;i++){
            for(int j = 0;j < cols;j++){
                chs[i][j] = matrix[index++];
            }
        }
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                char ch = chs[i][j];
                if(ch == str[0]){
                    if(hasPathCore(chs,i,j,str,0,visit)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[][] chs,int i,int j,char[] str,int index,int[][] visit){
        if(index == str.length){
            return true;
        }
        int row = chs.length;
        int col = chs[0].length;
        boolean flag = false;
        if(i >=0 && i<row && j >=0 && j < col){
            if(chs[i][j] == str[index] && visit[i][j] == 0){
                index++;
                visit[i][j]=1;
                flag = hasPathCore(chs,i+1,j,str,index,visit)
                        || hasPathCore(chs,i-1,j,str,index,visit)
                        || hasPathCore(chs,i,j+1,str,index,visit)
                        || hasPathCore(chs,i,j-1,str,index,visit);
                if(!flag){
                    visit[i][j] = 0;
                }
            }
        }
        return flag;
    }
}
