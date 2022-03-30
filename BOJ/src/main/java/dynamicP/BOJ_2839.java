package dynamicP

import java.io.*;
import java.util.Arrays;

public class BOJ_2839{
	public static void main(String[] args) throws IOException{
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		
		//기본 세팅
		Arrays.fill(dp, 5000);
    //if문 안넣어주면 ArrayIndexOutofBound 에러남
		if(n >= 3) dp[3] = 1; 
    if(n >= 5) dp[5] = 1;
		
		for(int i=6; i<=n; i++) dp[i] = Math.min(dp[i-3], dp[i-5])+1; //봉지 1개 추가
		
		//출력
		if(dp[n] >= 5000) System.out.println(-1);
		else System.out.println(dp[n]);
	}
}
