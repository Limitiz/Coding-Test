package dynamicP

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BOJ_2407 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		BigInteger[][] dp = new BigInteger[n+1][n+1];
		for(int i=0; i<n; i++) {
			dp[i][0] = new BigInteger("1");
			dp[i][i] = new BigInteger("1");
			dp[i][1] = new BigInteger(String.valueOf(i));
		}
		
		if(m > n/2) m = n-m;
		
		for(int i=2; i<=n; i++) {
			for(int j=2; j<i; j++) {
				if(dp[i][j] == null)
					dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
			}
		}
		
		System.out.println(dp[n][m]);
	}
}
