package greedy;

import java.io.*;
import java.util.*;

public class BOJ_12904 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		
		Queue<String> q = new LinkedList();
		q.add(s);
		while(!q.isEmpty()) {
			String cur = q.poll();
			//System.out.println(cur); //확인용 코드
			
			if(cur.equals(t)) {
				System.out.println(1);
				System.exit(0);
			}
			if(cur.length() == t.length()) continue;
			q.add(cur+"A");
			
			char[] tmp = new char[cur.length()+1];
			for(int i = 0; i<cur.length(); i++)
				tmp[i] = cur.charAt(cur.length()-1 - i);
			tmp[cur.length()] = 'B';
			
			q.add(String.valueOf(tmp));
			
		}
		System.out.println(0);
	}
}
