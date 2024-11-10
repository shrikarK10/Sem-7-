package DAA;
import java.util.*;
public class A4 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String []args) {
        System.out.println();
        int w = 3;
        int profit[] = {15, 14, 10, 45, 30};
        int weight[] = {2,5,1,3,4};
        int dp[][] = new int[profit.length+1][w+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;    
                }
                int currW = weight[i-1];
                int currP = profit[i-1];
                if(currW <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-currW]+currP);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[profit.length][w]);
    }
}