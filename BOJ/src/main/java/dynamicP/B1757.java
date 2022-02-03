package dynamicP;

import java.util.Scanner;

public class B1757 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] distance = new int[n];
        for(int i=0; i<n; i++)
            distance[i] = sc.nextInt();

        int dp[][][] = new int[n+1][m+2][2];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(j==0)
                    dp[i][0][0] = Math.max(Math.max(dp[i-1][0][0], dp[i-1][1][1]), dp[i-1][1][0]);
                else if(j==1) {
                    dp[i][1][0] = Math.max(dp[i-1][2][1], dp[i-1][2][0]) ;
                    dp[i][1][1] = dp[i-1][0][0] + distance[i-1];
                }
                else {
                    dp[i][j][0] = Math.max(dp[i-1][j+1][1], dp[i-1][j+1][0]);
                    dp[i][j][1] = dp[i-1][j-1][1] + distance[i-1];
                }
            }
        }

        System.out.println(dp[n][0][0]);
        sc.close();
    }
}
