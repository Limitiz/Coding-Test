package bruteForce_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11722 {
    static int[] a;
    static int n, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(0,0);
        System.out.println(max);
    }

    public static void dfs(int i, int len){
        if(len == n-1) {
            max = Math.max(max, len);
            return;
        }

        if(a[i+1]<a[i]) dfs(i+1, len+1); //감소하는 수열 추가
        dfs(i+1, len); //추가 안하고 넘어가기
    }
}
