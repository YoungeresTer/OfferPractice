package offerPractice;

/**
 * Created by Meihuan on 2018/4/19.
 */
public class In13 {
    public int movingCount(int threshold, int rows, int cols)
    {
        if(rows <= 0 || cols <= 0 || threshold < 0) return 0;
        int[][] visit = new int[rows][cols];
        return movingCountCore(rows,cols,0,0,threshold,visit);
    }

    private static int movingCountCore(int rows,int cols,int i,int j,int threshold,int[][] visit){
        if(i >= rows || j >= cols || i < 0 || j < 0 || visit[i][j] == 1) return 0;
        int count = 0;
        if(check(i,j,threshold)){
            visit[i][j] = 1;
            count = 1 + movingCountCore(rows,cols,i+1,j,threshold,visit)
                    + movingCountCore(rows,cols,i-1,j,threshold,visit)
                    + movingCountCore(rows,cols,i,j+1,threshold,visit)
                    + movingCountCore(rows,cols,i,j-1,threshold,visit);
        }
        return count;
    }

    private static boolean check(int i,int j,int threshold){
        if(getDigitSum(i) + getDigitSum(j) <= threshold) return true;
        return false;
    }

    private static int getDigitSum(int i){
        int sum = 0;
        while(i > 0){
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}
