package bruteForce_backTracking;

import java.io.*;
import java.util.*;

public class BOJ_1182 {
	static int[] seq;
	static int n, s, cnt = 0;

	public static void main(String[] args) throws IOException{
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		seq = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) seq[i] = Integer.parseInt(st.nextToken());
		
		//완전탐색
		dfs(0,0);
		
		if(s == 0) System.out.println(cnt-1);
		else System.out.println(cnt);
	}
	
	public static void dfs(int i, int sum) {
		if(i == n) {
			if(sum == s) cnt++;
			return;
		}
		
		dfs(i+1, sum+seq[i]); //더하고 넘어가기
		dfs(i+1, sum); //안 더하고 넘어가기
	}
}
