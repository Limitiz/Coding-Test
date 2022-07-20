package bruteForce_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651 {
    static StringBuilder sb = new StringBuilder();
    static int arr[];
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        int len = 0;
        dfs(len);
        System.out.println(sb);
    }

    public static void dfs(int len){
        //깊이 m까지 들어가면 stop
        if(m == len){
            for(int num : arr)
                sb.append(num+" ");

            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            arr[len] = i+1;
            dfs(len+1); //다음 탐색으로 ㄱㄱ
        }
    }
}
