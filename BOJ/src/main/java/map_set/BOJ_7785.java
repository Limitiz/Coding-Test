package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        TreeSet<String> set = new TreeSet();

        //set으로 구현 (value를 넣을 필요가 없음)
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if(set.contains(name)) set.remove(name);
            else set.add(name);
        }

        set = (TreeSet<String>)set.descendingSet();
        for(String i : set) sb.append(i+"\n");
        System.out.println(sb);
    }
}
