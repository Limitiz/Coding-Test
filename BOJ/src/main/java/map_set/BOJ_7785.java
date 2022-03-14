package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet();

        //set으로 구현 (value를 넣을 필요가 없음)
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if(set.contains(name)) set.remove(name);
            else set.add(name);
        }

        //set 정렬
        List<String> list = new ArrayList(set);
        Collections.sort(list, Comparator.reverseOrder());

        for(String i : list) System.out.println(i);
    }
}
