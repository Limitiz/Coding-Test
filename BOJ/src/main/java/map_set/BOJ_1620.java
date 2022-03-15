package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1620 {
    public static void main(String[] args) throws IOException{
        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> pocketmon = new HashMap<>();
        String answer[] = new String[m];

        for(int i=1; i<=n; i++) pocketmon.put(i, br.readLine());

        //정답 맞추기
        for(int i=0; i<m; i++) {
            String tmp = br.readLine();

            if(tmp.charAt(0) < 'A') //숫자입력 받음
                sb.append(pocketmon.get(Integer.parseInt(tmp))+"\n");

            else { //문자 입력받음
                for(int key : pocketmon.keySet()){
                    if(tmp.equals(pocketmon.get(key)))
                        sb.append(key+"\n");
                }
            }
        }

        System.out.println(sb);
    }
}