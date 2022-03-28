package greedy;

import java.io.*;
import java.util.*;
public class BOJ_4769 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int i = 0;
    
		while(true) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
      
			if((l+p+v) == 0) break;
			
			int max = v/p*l;
			max += Math.min(v%p, l);
			sb.append("Case "+(++i)+": "+max+"\n");
		}
		System.out.println(sb);
	}
}
