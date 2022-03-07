package greedy;

import java.io.*;
import java.util.*;

public class BOJ_12904 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		
		//거꾸로 t에서부터 s로 가기
		Queue<StringBuilder> q = new LinkedList();
		StringBuilder sb = new StringBuilder(t);
		q.add(sb);
		
		while(!q.isEmpty()) {
			StringBuilder cur = q.poll();
			System.out.println(cur);
			
			if(cur.equals(s)) {
				System.out.println(1);
				System.exit(0);
			}
			
			if(cur.length() == s.length()) continue;
			
			StringBuilder nxt;
      			//뒤에서 A 제거
			if(cur.charAt(cur.length()-1) == 'A') {
				nxt = new StringBuilder(cur.deleteCharAt(cur.length()-1));
				q.offer(nxt);
			}
      			//B제거하고 뒤집기
			else {
				nxt = new StringBuilder(cur.deleteCharAt(cur.length()-1));
				nxt.reverse();
				q.offer(nxt);
			}
		}
		
		System.out.println(0);
	}
}
