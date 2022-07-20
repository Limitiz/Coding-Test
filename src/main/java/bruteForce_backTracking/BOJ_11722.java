package bruteForce_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int dp[] = new int[n];
        int max = 0, num = 0;

        //dp
        dp[0] = 1; num = a[0];
        for(int i=1; i<n; i++){
            if(a[i]<a[i-1]) dp[i]++;
        }

        System.out.println(max);
    }
}