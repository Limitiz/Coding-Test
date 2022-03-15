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

        HashMap<String, Integer> name = new HashMap<>(); //이름으로 번호 찾기
        String num[] = new String[n+1]; //번호로 이름 찾기
        String answer[] = new String[m];

        for(int i=1; i<=n; i++) {
            String tmp = br.readLine();
            name.put(tmp, i);
            num[i] = tmp;
        }

        //정답 맞추기
        for(int i=0; i<m; i++) {
            String tmp = br.readLine();

            if(tmp.charAt(0) < 'A') //숫자 입력받음
                sb.append(num[Integer.parseInt(tmp)]+"\n");

            else // 문자 입력받음
                sb.append(name.get(tmp)+"\n");
        }
        System.out.println(sb);
    }
}