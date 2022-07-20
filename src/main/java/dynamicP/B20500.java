package dynamicP;

import java.util.Scanner;

public class B20500 {
    static final int MOD = 1000000007;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[][] = new int[n+1][3];
        dp[1][0] = 0; dp[1][1] = 1; dp[1][2] = 1;

        for(int i=2; i<n; i++){
            dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % MOD;
            dp[i][1] = (dp[i-1][2] + dp[i-1][0]) % MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }

        System.out.println(dp[n-1][1]);
        sc.close();
    }
}